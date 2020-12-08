package com.greenfox.music;

public abstract class Instrument {
    protected String name;
    protected int numberOfStrings;

    public Instrument(){
    }

    public Instrument(String name, int numberOfStrings) {
        this.name = name;
        this.numberOfStrings = numberOfStrings;
    }

    public abstract void play();
}
