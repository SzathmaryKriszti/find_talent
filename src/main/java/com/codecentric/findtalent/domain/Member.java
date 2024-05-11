package com.codecentric.findtalent.domain;

import jakarta.persistence.*;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String name;

    private String createdAt;

    private String avatarUrl;

    @OneToMany(mappedBy = "member")
    private List<Repo> repository;

    public Member(GHUser ghUser) {
        this.id = ghUser.getId();
        this.username = ghUser.getLogin();
        try {
            this.name = ghUser.getName();
            this.createdAt =ghUser.getCreatedAt().toString();
            if (ghUser.getName() == null){
                this.name = "This user has not provided a name";
            }
            if (ghUser.getCreatedAt() == null){
                this.createdAt = "Sorry, we don't know the date of creation.";
            }
        } catch (IOException e){
            this.name = "This user has not provided a name";
        }
        this.avatarUrl = ghUser.getAvatarUrl();
        this.repository = new ArrayList<>();
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

    public void setRepository(List<Repo> repository) {
        this.repository = repository;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
