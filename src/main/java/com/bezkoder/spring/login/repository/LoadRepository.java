package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Place;
import com.bezkoder.spring.login.models.Rank;
import com.bezkoder.spring.login.controllers.LoadController;
import com.bezkoder.spring.login.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoadRepository extends JpaRepository<Rank, Long> {
    List<Rank> findAll();
    Rank findByUsername(String username);

}
