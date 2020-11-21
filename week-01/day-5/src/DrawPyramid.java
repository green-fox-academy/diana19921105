//Write a program that reads a number from the standard input, then draws a
// pyramid like this:
//
//
//    *
//   ***
//  *****
// *******
//
// The pyramid should have as many lines as the number was

import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i += 2) {
            for (int numberOfSpaces = 1; numberOfSpaces <= (number - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int numberOfSpaces = 1; numberOfSpaces <= (number - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
