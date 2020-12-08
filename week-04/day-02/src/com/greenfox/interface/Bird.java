package Interface;

import com.greenfox.zoo.Animal;

public class Bird extends Animal implements Interface.Flyable {

    Bird(String name) {
        this.name = getName(name);
    }

    @Override
    public void fly() {
        System.out.println("The " + name +  " is flying...");
    }

    @Override
    public void land() {
        System.out.println("The " + name + " is landing...");
    }

    @Override
    public void takeoff() {
        System.out.println("The " + name + " takes off...");
    }
}
