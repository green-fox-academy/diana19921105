package com.greenfox.music;

public class Violin extends StringedInstrument {

    public Violin(String name, int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
        this.name = name;
    }

    public Violin() {
        super();
        name = "Violin";
        numberOfStrings = 4;
    }

    public Violin(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void sound() {
        System.out.println("Screech");
    }

    public void play() {
        System.out.println(name + ", a " + numberOfStrings + "- stringed instrument that goes ");
        this.sound();
    }
}
