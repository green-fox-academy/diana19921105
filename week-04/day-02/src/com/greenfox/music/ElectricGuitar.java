package com.greenfox.music;

public class ElectricGuitar extends StringedInstrument implements Play{

    public ElectricGuitar(String name, int numberOfStrings) {
       super(name, numberOfStrings);
    }

    public ElectricGuitar() {
        name = "Electric Guitar";
        numberOfStrings = 6;
    }


    @Override
    public void sound() {
        System.out.println("Twang");
    }

    public void play() {
        System.out.println(name + ", a " + numberOfStrings + "- stringed instrument that goes ");
        this.sound();
    }
}
