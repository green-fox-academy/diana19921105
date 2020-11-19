import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number of chickens!");
        int userInput = scanner.nextInt();
        System.out.println("Please enter a number of pigs!");
        int userInput2 = scanner.nextInt();

        int legsOfAnimals = userInput * 2 + userInput2 * 4;

        System.out.println("Total legs of animals: " + legsOfAnimals);
    }
}
