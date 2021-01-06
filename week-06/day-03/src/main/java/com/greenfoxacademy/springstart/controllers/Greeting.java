package com.greenfoxacademy.springstart.controllers;


import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
    private Long greetingCount;
    private String content;

    public Greeting(Long greetingCount, String content) {
        this.greetingCount = greetingCount;
        this.content = content;
    }

    public Long getGreetingCount() {
        return greetingCount;
    }

    public String getContent() {
        return content;
    }
}
