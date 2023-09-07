package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Place;
import com.bezkoder.spring.login.models.Rank;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.LoadRepository;
import com.bezkoder.spring.login.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/spot", produces = "application/json;charset=UTF-8")
public class LoadController {


    private final UserService userService;

    @Autowired
    public LoadController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping(value = "/load", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rank>> getRank() {
        List<Rank> places = loadRepository.findAll();
        System.out.println(loadRepository);
        return ResponseEntity.ok(places);
    }
    @GetMapping(value = "/pick", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Rank> getRankByUserName(@RequestParam String username) {
        Rank user = loadRepository.findByUsername(username);
        System.out.println(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(value = "/updateMessage")
    public ResponseEntity<String> updateMessage(@RequestBody Rank user) {
        System.out.println(user);
        try {
            // userService를 사용하여 username에 해당하는 사용자의 message 값을 업데이트합니다.
            userService.updateMessageByUsername(user.getUsername(), user.getMessage());
            return ResponseEntity.ok("Message updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update message");
        }
    }

    @PostMapping(value = "/updateimage")
    public ResponseEntity<String> updateimage(@RequestBody Rank user) {
        System.out.println(user);
        try {
            // userService를 사용하여 username에 해당하는 사용자의 message 값을 업데이트합니다.
            userService.updateImageByUsername(user.getUsername(), user.getImage());
            return ResponseEntity.ok("Message updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update message");
        }
    }
}
