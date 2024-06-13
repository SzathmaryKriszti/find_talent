package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.domain.Repo;
import com.codecentric.findtalent.dto.outgoing.MemberDetailsItem;
import com.codecentric.findtalent.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    private SearchService testSearchService;

    @Mock
    private MemberRepository testMemberRepository;

    @BeforeEach
    public void setUp() {
        this.testSearchService = new SearchService(testMemberRepository);
    }

    @Test
    public void searchMemberByLanguageTest() {

        String language = "scala";

        Member member1 = new Member();
        Member member2 = new Member();

        Repo repo1 = new Repo(member1, "java");
        Repo repo2 = new Repo(member1, "scala");
        Repo repo3 = new Repo(member2, "java");
        Repo repo4 = new Repo(member2, "scala");

        member1.setId(1L);
        member1.setUsername("username");
        member1.setName("name");
        member1.setLocation("location");
        member1.setEmail("email");
        member1.setBio("bio");
        member1.setCreatedAt("createdAt");
        member1.setAvatarUrl("url");
        member1.setRepository(Arrays.asList(
                repo1, repo2
        ));

        member2.setId(2L);
        member2.setUsername("username2");
        member2.setName("name2");
        member2.setLocation("location2");
        member2.setEmail("email2");
        member2.setBio("bio2");
        member2.setCreatedAt("createdAt2");
        member2.setAvatarUrl("url2");
        member2.setRepository(Arrays.asList(
                repo3, repo4
        ));

        List<Member> membersByLanguage = new ArrayList<>();
       membersByLanguage.add(member1);
       membersByLanguage.add(member2);


        when(testMemberRepository.findDistinctMembersByRepositoryLanguage(language)).thenReturn(membersByLanguage);

        List<MemberDetailsItem> actualMemberDetailsItems = testSearchService.searchMemberByLanguage(language);

        Assertions.assertFalse(actualMemberDetailsItems.isEmpty());
        assertEquals(2, actualMemberDetailsItems.size());

    }

}
