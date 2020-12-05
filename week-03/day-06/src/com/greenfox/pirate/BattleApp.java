package com.greenfox.pirate;

public class BattleApp {
    public static void main(String[] args) {
        Ship ship = new Ship();
        Ship other = new Ship();

        ship.fillShip();
        other.fillShip();
        ship.battle(other);
    }
}
