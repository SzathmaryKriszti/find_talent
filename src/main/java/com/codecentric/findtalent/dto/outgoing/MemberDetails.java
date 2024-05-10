package com.codecentric.findtalent.dto.outgoing;

import com.codecentric.findtalent.domain.Member;

import java.util.List;

public class MemberDetails {

    private List<Member> membersByLanguage;

    public MemberDetails(List<Member> membersByLanguage) {
        this.membersByLanguage = membersByLanguage;
    }

    public List<Member> getMembersByLanguage() {
        return membersByLanguage;
    }

    public void setMembersByLanguage(List<Member> membersByLanguage) {
        this.membersByLanguage = membersByLanguage;
    }
}
