package com.codecentric.findtalent.dto.outgoing;

import java.util.List;

public class MemberDetails {

    private List<MemberDetailsItem> membersByLanguage;

    public MemberDetails(List<MemberDetailsItem> membersByLanguage) {
        this.membersByLanguage = membersByLanguage;
    }

    public List<MemberDetailsItem> getMembersByLanguage() {
        return membersByLanguage;
    }

    public void setMembersByLanguage(List<MemberDetailsItem> membersByLanguage) {
        this.membersByLanguage = membersByLanguage;
    }
}
