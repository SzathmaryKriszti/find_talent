package com.codecentric.findtalent.service;

import com.codecentric.findtalent.domain.Member;
import com.codecentric.findtalent.domain.Repo;
import com.codecentric.findtalent.dto.outgoing.MemberDetailsItem;
import com.codecentric.findtalent.repository.MemberRepository;
import com.codecentric.findtalent.repository.RepoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class SearchServiceTest {

    private SearchService testSearchService;

    @Mock
    private RepoRepository testRepoRepository;

    @Mock
    private MemberRepository testMemberRepository;

    @BeforeEach
    public void setUp() {
        this.testSearchService = new SearchService(testMemberRepository, testRepoRepository);
    }

    @Test
    public void searchMemberByLanguageTest() {

        String language = "Scala";

        Member member1 = new Member();
        Member member2 = new Member();

        Repo repo1 = new Repo(member1, "Java");
        Repo repo2 = new Repo(member1, "Scala");
        Repo repo3 = new Repo(member2, "Java");
        Repo repo4 = new Repo(member2, "Scala");

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

        List<Repo> reposByLanguage = new ArrayList<>();
        reposByLanguage.add(repo2);
        reposByLanguage.add(repo4);


        when(testRepoRepository.findReposByLanguage(language)).thenReturn(reposByLanguage);

        List<MemberDetailsItem> actualMemberDetailsItems = testSearchService.searchMemberByLanguage(language);

        Assertions.assertFalse(actualMemberDetailsItems.isEmpty());
        assertEquals(2, actualMemberDetailsItems.size());

    }
}
