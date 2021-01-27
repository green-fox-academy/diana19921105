package com.greenfox.resttests.controller;

import org.junit.runner.RunWith;

import com.greenfox.resttests.model.GrootResult;
import com.greenfox.resttests.model.GrootError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GuardianController {

    @GetMapping("/groot")
    public ResponseEntity<?> groot(@RequestParam(required = false) String message) {
        if (message != null) {
            return ResponseEntity.ok(new GrootResult(message));
        } else {
            return ResponseEntity.badRequest().body(new GrootError("I am Groot!"));
        }
    }
}
