package com.greenfox.springsql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller ("/todo")
@ResponseBody
public class TodoController {

    @GetMapping(value = {"/","/list"})
    public String list() {
        return "This is my first Todo";
    }
}
