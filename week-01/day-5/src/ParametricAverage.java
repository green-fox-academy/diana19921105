// Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4

import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int number = scanner.nextInt();

        int sum = 0;
        double average = 0.0;
        int integer = 0;

        for (int i = 0; i < number; i++) {
            System.out.println("Please enter an integer!");
            integer = scanner.nextInt();
            sum += integer;
            average = (double) sum / number;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
