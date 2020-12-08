package com.greenfox.music;

public class BassGuitar extends StringedInstrument {

    public BassGuitar(String name, int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
        this.name = name;
    }

    public BassGuitar() {
        super();
        name = "Bass Guitar";
        numberOfStrings = 4;
    }

    @Override
    public void sound() {
        System.out.println("Duum-duum-duum");
    }

    public void play() {
        System.out.println(name + ", a " + numberOfStrings + "- stringed instrument that goes ");
        this.sound();
    }
}
