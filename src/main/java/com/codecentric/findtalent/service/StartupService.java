package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.domain.Repo;
import com.codecentric.findtalent.repository.MemberRepository;
import com.codecentric.findtalent.repository.RepoRepository;
import jakarta.annotation.PostConstruct;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostConstruct
    public void init() throws IOException {


        repoRepository.deleteAll();
        memberRepository.deleteAll();


        GitHub github = GitHub.connect();

        GHOrganization org = github.getOrganization("codecentric");

        List<GHUser> ghUsers = org.listMembers().toList();

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

    }
}
