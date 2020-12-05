package com.greenfox.pirate;

import java.util.Random;

public class Pirate {
    int numberOfRum;
    boolean isAlive;

    public Pirate(int numberOfRum) {
        this.numberOfRum = numberOfRum;
        this.isAlive = true;
    }

    public void drinkSomeRum() {
        if (isAlive) {
            Random random = new Random();
            int drinkSome = random.nextInt(5);
            numberOfRum += drinkSome;
            //System.out.println("I have drunk " + numberOfRum + " rums");
        } else {
            System.out.println("He is dead.");
        }
    }

    public void die() {
        isAlive = false;
    }

    public void howIsItGoingMate() {
        if (numberOfRum >= 0 && numberOfRum <= 4) {
            System.out.println("Pour me anudder.");
            drinkSomeRum();
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }
    }

    public void brawl(Pirate another) {
        if (another.isAlive) {
            Random random = new Random();
            int chance = random.nextInt(3);
            if (chance == 0) {
                die();
                System.out.println("Another pirate wins.");
            } else if (chance == 1) {
                another.die();
                System.out.println("This pirate wins");
            } else {
                System.out.println("Nobody dies. Pirates pass out.");
            }
        }
    }
}
