package com.greenfox.zoo;

public class ZooApp {
    public static void main(String[] args) {
        Mammal mammal = new Mammal("Koala");
        Bird bird = new Bird("Parrot");
        Reptile reptile = new Reptile("Crocodile");

        System.out.println("How do you breed?");
        System.out.println("A " + mammal.getName(mammal.name) + " is breeding by " + mammal.breed());
        System.out.println("A " + bird.getName(bird.name) + " is breeding by " + bird.layingEggs());
        System.out.println("A " + reptile.getName(reptile.name) + " is breeding by " + reptile.layingEggs());
    }
}
