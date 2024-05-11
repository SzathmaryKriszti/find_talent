package com.codecentric.findtalent.controller;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.dto.outgoing.MemberDetailsItem;
import com.codecentric.findtalent.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/searches")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/member")
    public ResponseEntity<List<MemberDetailsItem>> searchMemberByLanguage(@RequestParam String language) {
        return new ResponseEntity<List<MemberDetailsItem>>(searchService.searchMemberByLanguage(language), HttpStatus.FOUND);
    }

    @GetMapping("/member-details/{id}")
    public ResponseEntity<MemberDetailsItem> getMemberDetails(@PathVariable Long id) {

        Optional<MemberDetailsItem> optionalMemberDetailsItem = searchService.getMemberDetails(id);
        if (optionalMemberDetailsItem.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MemberDetailsItem memberDetailsItem = optionalMemberDetailsItem.get();
        return new ResponseEntity<MemberDetailsItem>(memberDetailsItem, HttpStatus.OK);
    }
}
