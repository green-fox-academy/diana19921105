//Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was

import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (i == j || i == 1 || i == number || j == 1 || j == number) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

