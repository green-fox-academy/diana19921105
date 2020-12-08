package Interface;

public class Helicopter extends Interface.Vehicle implements Interface.Flyable {

    public Helicopter(String color, String name, int age) {
        super(color, name, age);
    }

    @Override
    public void fly() {
        System.out.println("The " + color + " " + name + " that is " + age + " year old is flying...");
    }

    @Override
    public void land() {
        System.out.println("The " + color + " " + name + " that is " + age + " year old is landing...");
    }

    @Override
    public void takeoff() {
        System.out.println("The " + color + " " + name + " that is " + age + " year old takes off...");
    }
}
