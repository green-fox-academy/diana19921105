package com.greenfox.music;

public class BassGuitar extends StringedInstrument {

    public BassGuitar(String name, int numberOfStrings) {
        super(name, numberOfStrings);
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
        System.out.print(name + ", a " + numberOfStrings + "- stringed instrument that goes ");
        this.sound();
    }
}
