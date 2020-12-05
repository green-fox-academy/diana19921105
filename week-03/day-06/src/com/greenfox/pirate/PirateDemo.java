package com.greenfox.pirate;

public class PirateDemo {
    public static void main(String[] args) {
        Pirate pirate = new Pirate(3);
        Pirate anotherPirate = new Pirate(5);
        Ship ship = new Ship();
        Ship other = new Ship();

        System.out.println(pirate.numberOfRum);
        System.out.println(anotherPirate.numberOfRum);

        System.out.println(pirate.isAlive);
        System.out.println(anotherPirate.isAlive);

        pirate.drinkSomeRum();
        anotherPirate.drinkSomeRum();

        pirate.howIsItGoingMate();
        anotherPirate.howIsItGoingMate();

        pirate.brawl(anotherPirate);

    }
}