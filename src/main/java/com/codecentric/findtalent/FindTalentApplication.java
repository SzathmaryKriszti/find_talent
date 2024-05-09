package com.codecentric.findtalent;

import com.codecentric.findtalent.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindTalentApplication{

    public StartupService startupService;

    @Autowired
    public FindTalentApplication(StartupService startupService) {
        this.startupService = startupService;
    }


    public static void main(String[] args){
        SpringApplication.run(FindTalentApplication.class, args);
    }

}



