package com.codecentric.findtalent.domain;

import jakarta.persistence.*;
import org.kohsuke.github.GHUser;

import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String avatarUrl;

    @OneToMany
    @JoinTable(name = "members_repos", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "repo_id")})
    private List<Repo> repository;

    public Member(GHUser ghUser) {
        this.id = ghUser.getId();
        this.username = ghUser.getLogin();
        this.avatarUrl = ghUser.getAvatarUrl();
    }

    public Member() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Repo> getRepository() {
        return repository;
    }

    public void setRepository(Repo repository) {
            this.repository.add(repository);
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
