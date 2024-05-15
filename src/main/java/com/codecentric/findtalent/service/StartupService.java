package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.domain.Repo;
import com.codecentric.findtalent.repository.MemberRepository;
import com.codecentric.findtalent.repository.RepoRepository;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StartupService {

    private final MemberRepository memberRepository;
    private final RepoRepository repoRepository;

    @Autowired
    public StartupService(MemberRepository memberRepository, RepoRepository repoRepository) {
        this.memberRepository = memberRepository;
        this.repoRepository = repoRepository;
    }

//    The @PostConstruct annotation could also be used here, but I used SmartInitialisingSingleton based on this comment:
//    https://stackoverflow.com/a/48771885
    @Bean
    @Profile("!test")
    public SmartInitializingSingleton init() {


        repoRepository.deleteAll();
        memberRepository.deleteAll();

        SmartInitializingSingleton singleton = new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                GitHub github;

                try {
                    github = GitHub.connect();

                    GHOrganization org = github.getOrganization("codecentric");

                    List<GHUser> ghUsers = org.getMembers();

                    for (GHUser ghUser : ghUsers) {

                        Member member = new Member(ghUser);
                        Member savedMember = memberRepository.save(member);
                        Map<String, GHRepository> memberRepos = ghUser.getRepositories();

                        for (GHRepository ghRepository : memberRepos.values()) {
                            Repo repository = new Repo(ghRepository);
                            repository.setMember(savedMember);
                            repoRepository.save(repository);
                        }
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return singleton;
    }
}
