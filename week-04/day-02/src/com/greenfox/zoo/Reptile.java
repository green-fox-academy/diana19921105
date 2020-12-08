package com.greenfox.zoo;

public class Reptile extends Animal implements LayingEggs{


    Reptile(String name) {
        this.name = getName(name);
    }

    @Override
    public String layingEggs() {
        return "laying eggs";
    }

    public boolean hasScales() {
        return true;
    }
}
