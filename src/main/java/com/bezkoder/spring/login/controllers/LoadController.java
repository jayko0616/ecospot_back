package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Rank;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/spot", produces = "application/json;charset=UTF-8")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping(value = "/load", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rank>> getRank() {
        List<Rank> places = loadRepository.findAll();
        System.out.println(loadRepository);
        return ResponseEntity.ok(places);
    }
    @GetMapping(value = "/pick", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rank>> getRankByUserName(@RequestParam String username) {
        List<Rank> user = loadRepository.findByUsername(username);
        System.out.println(user);
        if (!user.isEmpty()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
