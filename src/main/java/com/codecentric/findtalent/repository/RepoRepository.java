package com.codecentric.findtalent.repository;

import com.codecentric.findtalent.domain.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {

}
