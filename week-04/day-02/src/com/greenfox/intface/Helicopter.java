package com.greenfox.intface;

public class Helicopter extends Vehicle implements Flyable {

    public Helicopter(String name, String color, int age) {
        super(name, color, age);
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
