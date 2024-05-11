package com.codecentric.findtalent.dto.outgoing;

import com.codecentric.findtalent.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberDetailsItem {

    private Long id;
    private String username;
    private String avatarUrl;
    private List<RepoDetailsItem> repoDetailsItemList;

    public MemberDetailsItem(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.avatarUrl = member.getAvatarUrl();
        this.repoDetailsItemList = member.getRepository().stream().map(RepoDetailsItem::new).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<RepoDetailsItem> getRepoDetailsItemList() {
        return repoDetailsItemList;
    }

    public void setRepoDetailsItemList(List<RepoDetailsItem> repoDetailsItemList) {
        this.repoDetailsItemList = repoDetailsItemList;
    }
}
