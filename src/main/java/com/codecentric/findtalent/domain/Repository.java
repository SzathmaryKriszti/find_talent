package com.codecentric.findtalent.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "repos")
public class Repository {

    @Id
    @Column(name = "repo_id")
    private Long id;

    @ManyToOne
    private Member member;

    private String language;

    public Repository(Long id, Member member, String language) {
        this.id = id;
        this.member = member;
        this.language = language;
    }

    public Repository() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
