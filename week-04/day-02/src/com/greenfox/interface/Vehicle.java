package Interface;

public abstract class Vehicle {
    String color;
    String name;
    int age;

    public Vehicle(String color, String name, int age) {
        this.age = age;
        this.name = name;
        this.color = color;
    }
}
