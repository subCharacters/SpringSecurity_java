package com.example.springsecurity_java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/v1/reviews")
public class ReviewController {
    @PostMapping
    public ResponseEntity<String> writeReview() {

        return ResponseEntity.ok().body("review is posted");
    }
}
