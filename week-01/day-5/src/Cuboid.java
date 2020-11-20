// Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000

public class Cuboid {
    public static void main(String[] args) {
        double length = 2.0;
        double width = 3.2;
        double height = 5.0;

        double volume = length * width * height;
        double surfaceArea = 2 * (length + width + height);

        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }
}
