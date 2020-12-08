package com.greenfox.music;

public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;

    public StringedInstrument(String name, int numberOfStrings) {
        this.name = name;
        this.numberOfStrings = numberOfStrings;
    }


    public StringedInstrument() {

    }

    public abstract void sound();
}
