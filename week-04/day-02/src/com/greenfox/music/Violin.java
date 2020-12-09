package com.greenfox.music;

public class Violin extends StringedInstrument {

    public Violin(String name, int numberOfStrings) {
       super(name, numberOfStrings);
    }

    public Violin(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public Violin() {
        name = "Violin";
        numberOfStrings = 4;
    }


    @Override
    public void sound() {
        System.out.println("Screech");
    }

    public void play() {
        System.out.print(name + ", a " + numberOfStrings + "- stringed instrument that goes ");
        this.sound();
    }
}
