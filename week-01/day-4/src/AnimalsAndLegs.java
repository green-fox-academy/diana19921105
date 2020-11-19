import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number of chickens!");
        int numberOfChickens = scanner.nextInt();
        System.out.println("Please enter a number of pigs!");
        int numberOfPigs = scanner.nextInt();

        int legsOfAnimals = numberOfChickens * 2 + numberOfPigs * 4;

        System.out.println("Total legs of animals: " + legsOfAnimals);
    }
}
