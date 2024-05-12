package com.codecentric.findtalent.domain;

import jakarta.persistence.*;
import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.net.URL;

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

    private URL url;

    private String repoName;

    private String createdAt;

    @Column(columnDefinition = "TEXT")
    private String description;


    public Repo(GHRepository ghRepository) {
        this.id = ghRepository.getId();
        this.language = ghRepository.getLanguage();
        this.url = ghRepository.getHtmlUrl();
        this.repoName = ghRepository.getFullName();
        if (ghRepository.getDescription() == null) {
            this.description = "no description";
        } else {
            this.description = ghRepository.getDescription();
        }
        try {
            this.createdAt = ghRepository.getCreatedAt().toString();
        } catch (IOException e) {
            this.createdAt = "Sorry, we don't know the date of creation.";
        }
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }


    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
