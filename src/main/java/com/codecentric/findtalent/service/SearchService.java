package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.domain.Repo;
import com.codecentric.findtalent.dto.outgoing.MemberDetails;
import com.codecentric.findtalent.repository.MemberRepository;
import com.codecentric.findtalent.repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchService {

    private final MemberRepository memberRepository;
    private final RepoRepository repoRepository;

    @Autowired
    public SearchService(MemberRepository memberRepository, RepoRepository repoRepository) {
        this.memberRepository = memberRepository;
        this.repoRepository = repoRepository;
    }


    public MemberDetails searchMemberByLanguage(String language) {
        List<Member> membersByLanguage = new ArrayList<>();
        List<Repo> repos = repoRepository.findRepoByLanguage(language);
        if (!repos.isEmpty()) {
            for (Repo repo : repos) {
                Member member = repo.getMember();
                if (!membersByLanguage.contains(member)) {
                    membersByLanguage.add(member);
                }
            }
        }
        return new MemberDetails(membersByLanguage);
    }


}
