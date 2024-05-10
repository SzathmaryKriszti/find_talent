package com.codecentric.findtalent.repository;

import com.codecentric.findtalent.domain.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {

    @Query("SELECT r FROM Repo r WHERE r.language = :language")
    List<Repo> findRepoByLanguage(String language);
}
