package com.greenfox.pirate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {
    List<Ship> ships;

    public Armada() {
        this.ships = new ArrayList<>();
    }

    public void fillArmada() {
        Random random = new Random();
        int numberOfShips = random.nextInt(50);
        for (int i = 0; i < numberOfShips; i++) {
            Ship ship = new Ship();
            ship.fillShip();
            ships.add(ship);
        }
    }

    public boolean war(Armada other) {
        int i = 0;
        int j = 0;
        while (this.ships.size() > i && other.ships.size() > j) {
            boolean battleResult = this.ships.get(i).battle(other.ships.get(j));
            if (battleResult) {
                other.ships.remove(j);
            } else {
                ships.remove(i);
            }
        }
        if (ships.size() > 0) {
            System.out.println("This armada wins");
            return true;
        } else {
            System.out.println("Other armada wins");
            return false;
        }
    }
}
