package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Rank, Long> {
    List<Rank> findAll();
}
