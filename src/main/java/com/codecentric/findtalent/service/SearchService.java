package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.dto.outgoing.MemberDetailsItem;
import com.codecentric.findtalent.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    private final MemberRepository memberRepository;

    @Autowired
    public SearchService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public List<MemberDetailsItem> searchMemberByLanguage(String language) {
        List<Member> membersByLanguage = memberRepository.findDistinctMembersByRepositoryLanguage(language);

        return membersByLanguage.stream().map(MemberDetailsItem::new).collect(Collectors.toList());
    }


    public Optional<MemberDetailsItem> getMemberDetails(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        return optionalMember.map(MemberDetailsItem::new);
    }
}
