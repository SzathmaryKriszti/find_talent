package com.codecentric.findtalent.controller;

import com.codecentric.findtalent.dto.outgoing.MemberDetails;
import com.codecentric.findtalent.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/searches")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/member")
    public ResponseEntity<MemberDetails> searchMemberByLanguage(@RequestParam String language) {
        return new ResponseEntity<MemberDetails>(searchService.searchMemberByLanguage(language), HttpStatus.OK);
    }
}