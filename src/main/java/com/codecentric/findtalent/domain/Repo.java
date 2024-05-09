package com.codecentric.findtalent.domain;

import jakarta.persistence.*;
import org.kohsuke.github.GHRepository;

@Entity
@Table(name = "repos")
public class Repo {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String language;

    public Repo(GHRepository ghRepository) {
        this.id = ghRepository.getId();
        this.language = ghRepository.getLanguage();
    }


    public Repo() {
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
