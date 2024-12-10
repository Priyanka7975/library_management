package com.example.library.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.status(200).body("Welcome to the Home Page");
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        return ResponseEntity.status(200).body("Please login to continue");
    }
}

