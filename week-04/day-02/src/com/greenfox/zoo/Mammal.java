package com.greenfox.zoo;

public class Mammal extends Animal {
    public Mammal(String name) {
        this.name = getName(name);
    }


    public String breed() {
        return "pushing miniature versions out.";
    }

    public boolean hasHair() {
        return true;
    }

    public boolean hasBeak() {
        return true;
    }
}
