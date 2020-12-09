package com.greenfox.zoo;

public class Bird extends Animal implements LayingEggs {

    Bird(String name) {
        this.name = name;
    }

    public boolean hasFeathers() {
        return true;
    }

    @Override
    public String layingEggs() {
        return "laying eggs";
    }
}
