package com.codecentric.findtalent;

import com.jcabi.github.*;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

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
                final Github github = new RtGithub();
                Organization org = github.organizations().get("codecentric");

                for (User user : org.publicMembers().iterate()) {
                    try {
                        System.out.println(user.login());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        return singleton;
    }
}



