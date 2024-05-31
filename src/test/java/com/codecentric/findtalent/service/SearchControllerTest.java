package com.codecentric.findtalent.service;

import com.codecentric.findtalent.controller.SearchController;
import com.codecentric.findtalent.dto.outgoing.MemberDetailsItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchControllerTest {

    private SearchController searchController;

    @Mock
    private SearchService testSearchService;


    @BeforeEach
    public void setUp() {this.searchController = new SearchController(testSearchService);}


    @Test
    public void searchMemberByLanguageTest() {

        String language = "Java";
        List<MemberDetailsItem> expectedMemberList = new ArrayList<>();
        MemberDetailsItem memberDetailsItem = new MemberDetailsItem();
        memberDetailsItem.setId(1L);
        expectedMemberList.add(memberDetailsItem);

        when(testSearchService.searchMemberByLanguage(language)).thenReturn(expectedMemberList);

        ResponseEntity<List<MemberDetailsItem>> response = searchController.searchMemberByLanguage(language);

        verify(testSearchService, times(1)).searchMemberByLanguage(language);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedMemberList.get(0).getId(), Objects.requireNonNull(response.getBody()).get(0).getId());

    }
}
