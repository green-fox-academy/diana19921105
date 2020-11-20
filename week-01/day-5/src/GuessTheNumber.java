// Write a program that stores a number, and the user has to figure it out.
// The user can input guesses, after each guess the program would tell one
// of the following:
//
// The stored number is higher
// The stored number is lower
// You found the number: 8

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int storedNumber = 8;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which number did I think?");
        int guessNumber = 0;

        do {
            guessNumber = scanner.nextInt();

            if (storedNumber > guessNumber) {
                System.out.println("The stored number is higher");

            } else if (storedNumber < guessNumber) {
                System.out.println("The stored number is lower");

            } else {
                System.out.println("You found the number: " + guessNumber);
            }
        } while (guessNumber != storedNumber);
    }
}

