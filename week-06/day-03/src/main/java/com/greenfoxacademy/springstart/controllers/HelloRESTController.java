package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {
    AtomicLong counter = new AtomicLong(1);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam String name) {
        return new Greeting(counter.getAndIncrement(), "Hello " + name);
    }
}
