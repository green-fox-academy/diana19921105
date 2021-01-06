package com.greenfoxacademy.springstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringStartController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
