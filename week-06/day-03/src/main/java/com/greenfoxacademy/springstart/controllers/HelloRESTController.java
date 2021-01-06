package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam String name) {
        return new Greeting(1L, "Hello " + name);
    }
}
