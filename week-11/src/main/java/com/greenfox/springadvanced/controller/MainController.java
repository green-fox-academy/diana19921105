package com.greenfox.springadvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/lofaszka")
    public String helloWorld() {
        return "Hello World";
    }
}
