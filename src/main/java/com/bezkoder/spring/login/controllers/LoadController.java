package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Rank;
import com.bezkoder.spring.login.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spot")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping("/load")
    public ResponseEntity<List<Rank>> getRank() {
        List<Rank> places = loadRepository.findAll();
        System.out.println(loadRepository);
        return ResponseEntity.ok(places);
    }
}
