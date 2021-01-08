package com.greenfox.basicwebshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebshopController {

    @GetMapping("/webshop")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }
}
