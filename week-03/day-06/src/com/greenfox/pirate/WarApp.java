package com.greenfox.pirate;

public class WarApp {
    public static void main(String[] args) {
        Armada armada = new Armada();
        Armada other = new Armada();

        armada.fillArmada();
        other.fillArmada();

       armada.war(other);

    }
}
