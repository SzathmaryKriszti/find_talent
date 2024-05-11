package com.codecentric.findtalent.dto.outgoing;

import com.codecentric.findtalent.domain.Repo;

import java.net.URL;

public class RepoDetailsItem {

private Long id;
private String member;
private String language;
private URL url;


    public RepoDetailsItem(Repo repo) {
        this.id = repo.getId();
        this.member = repo.getMember().getUsername();
        this.language = repo.getLanguage();
        this.url = repo.getUrl();
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

}
