package com.codecentric.findtalent.dto.outgoing;

import java.util.List;

public class RepoDetails {

    private List<RepoDetailsItem> reposByLanguage;

    public RepoDetails(List<RepoDetailsItem> reposByLanguage) {
        this.reposByLanguage = reposByLanguage;
    }

    public List<RepoDetailsItem> getReposByLanguage() {
        return reposByLanguage;
    }

    public void setReposByLanguage(List<RepoDetailsItem> reposByLanguage) {
        this.reposByLanguage = reposByLanguage;
    }
}
