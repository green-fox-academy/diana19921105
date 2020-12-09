package com.greenfox.intface;

import com.greenfox.zoo.Animal;

public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String takeoff() {
        return "takes off";
    }

    @Override
    public String fly() {
        return "is flying";
    }

    @Override
    public String land() {
        return "is landing";
    }
}
