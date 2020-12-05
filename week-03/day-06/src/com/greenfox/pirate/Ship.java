package com.greenfox.pirate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    List<Pirate> pirates;
    Pirate captain;

    public Ship() {
        pirates = new ArrayList<>();

    }

    public void fillShip() {
        captain = new Pirate(4);
        Random random = new Random();
        int numberOfCrew = random.nextInt(15) + 1;
        for (int i = 0; i < numberOfCrew; i++) {
            pirates.add(new Pirate(8));
        }
        System.out.println("The number of crew is: " + numberOfCrew);
    }

    public boolean battle(Ship other) {
        int calculatedScore = calculatedScore();
        int anotherShipScore = other.calculatedScore();
        if (calculatedScore > anotherShipScore) {
            other.killRandomPirates();
            for (Pirate pirate : pirates) {
                pirate.drinkSomeRum();
            }

            System.out.println("This ship wins");
            return true;
        } else {
            this.killRandomPirates();
            for (Pirate pirate : other.pirates) {
                pirate.drinkSomeRum();
            }
            System.out.println("Another ship wins.");
            return false;
        }
    }

    private int calculatedScore() {
        int numOfRum = this.captain.numberOfRum;
        int alivePirates = getAlivePirates();
        return alivePirates - numOfRum;
    }

    private int getAlivePirates() {
        int alivePirates = 0;

        for (Pirate pirate : pirates) {
            if (pirate.isAlive) {
                alivePirates++;
            }
        }
        return alivePirates;
    }

    private void killRandomPirates() {
        Random random = new Random();
        int killNumber = random.nextInt(getAlivePirates() + 1);
        for (Pirate pirate : pirates) {
            if (pirate.isAlive) {
                pirate.die();
                killNumber--;
                if (killNumber == 0) {
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        int aliveNumber = getAlivePirates();
        if (captain == null) {
            return "No captain.";
        } else {

            return captain + " " + captain.isAlive + "consumed rum is: " + captain.numberOfRum + "\n" + "The number of alive pirates is: " + aliveNumber;
        }
    }
}
