//Write a program that reads a number from the standard input,then draws a
// diamond like this:
//
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *

import java.util.Scanner;

public class DrawDiamond {
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
        for (int i = number - 2; i >= 1; i -= 2) {
            for (int numberOfSpaces = 1; numberOfSpaces <= (number - 2 - i) / 2 + 1; numberOfSpaces++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int numberOfSpaces = 1; numberOfSpaces <= (number - 2 - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
