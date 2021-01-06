package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(12L, "hjhhj");
    }
}
