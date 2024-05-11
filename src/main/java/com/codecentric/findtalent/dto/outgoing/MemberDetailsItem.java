package com.codecentric.findtalent.dto.outgoing;

import com.codecentric.findtalent.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberDetailsItem {

    private Long id;
    private String username;
    private String name;
    private String createdAt;
    private String avatarUrl;
    private List<RepoDetailsItem> repoDetailsItemList;

    public MemberDetailsItem(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.name = member.getName();
        this.createdAt = member.getCreatedAt();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<RepoDetailsItem> getRepoDetailsItemList() {
        return repoDetailsItemList;
    }

    public void setRepoDetailsItemList(List<RepoDetailsItem> repoDetailsItemList) {
        this.repoDetailsItemList = repoDetailsItemList;
    }
}
