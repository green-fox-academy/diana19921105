package com.greenfox.intface;

public class InterfaceDemo {
    public static void main(String[] args) {
        Bird bird = new Bird("Parrot");
        Helicopter helicopter = new Helicopter("helicopter", "black", 2);

        System.out.println("The " + bird.getName("Parrot ") + bird.takeoff());
        System.out.println("The " + bird.getName("Parrot ") + bird.fly());
        System.out.println("The " + bird.getName("Parrot ") + bird.land());

        System.out.println("The " + helicopter.color + helicopter.name + " that is " + helicopter.age + " years old " + helicopter.takeoff());
        System.out.println("The " + helicopter.color + helicopter.name + " that is " + helicopter.age + " years old " + helicopter.fly());
        System.out.println("The " + helicopter.color + helicopter.name + " that is " + helicopter.age + " years old " + helicopter.land());
    }
}
