package com.codecentric.findtalent.repository;

import com.codecentric.findtalent.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{


    @Query("SELECT DISTINCT m FROM Member m JOIN Repo r ON m.id = r.member.id WHERE r.language = :language")
    List<Member> findDistinctMembersByRepositoryLanguage(String language);
}
