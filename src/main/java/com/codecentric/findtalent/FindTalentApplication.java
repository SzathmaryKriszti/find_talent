package com.codecentric.findtalent;

import org.kohsuke.github.GHOrganization;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class FindTalentApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FindTalentApplication.class, args);
    }


    @Bean
    public SmartInitializingSingleton init() {
        SmartInitializingSingleton singleton = new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                GitHub github = null;

                try {
                    github = GitHub.connect();
                    //        GitHub github = GitHub.connectAnonymously();


                    GHOrganization org = github.getOrganization("codecentric");
                    List<GHUser> members = org.getMembers();


                    for (GHUser member : members) {
                        Map<String, GHRepository> memberRepos = member.getRepositories();
                        for (GHRepository repository : memberRepos.values()){
                           String language = repository.getLanguage();
                            System.out.println(language);
                        }
                    }







                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        };
        return singleton;
    }


}



