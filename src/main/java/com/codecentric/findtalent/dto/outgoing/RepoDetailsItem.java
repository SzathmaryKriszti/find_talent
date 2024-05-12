package com.codecentric.findtalent.dto.outgoing;

import com.codecentric.findtalent.domain.Repo;

import java.net.URL;

public class RepoDetailsItem {

private Long id;
private String member;
private String language;
private URL url;
private String repoName;
private String createdAt;



    public RepoDetailsItem(Repo repo) {
        this.id = repo.getId();
        this.member = repo.getMember().getUsername();
        this.language = repo.getLanguage();
        this.url = repo.getUrl();
        this.repoName = repo.getRepoName();
        this.createdAt = repo.getCreatedAt();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
}
