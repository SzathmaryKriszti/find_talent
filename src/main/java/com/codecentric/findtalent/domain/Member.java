package com.codecentric.findtalent.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    private Long id;

    private String username;

    private String avatarUrl;

    @OneToMany
    @JoinTable(name = "members_repos", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "repo_id")})
    private List<Repository> repository;

    public Member(Long id, String username, String avatarUrl, List<Repository> repository) {
        this.id = id;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.repository = repository;
    }

    public Member() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Repository> getRepository() {
        return repository;
    }

    public void setRepository(List<Repository> repository) {
        this.repository = repository;
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
}
