// Create a program that asks for a number and prints the multiplication table with that number

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer!");
        int number = scanner.nextInt();

        int result;

        for (int i = 1; i <= 10; i++) {
            result = number * i ;
            System.out.println(i + " * " + number + " = " + result);
        }

    }
}
