// Crate a program that draws a chess table like this
//
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
//

import java.util.Scanner;

public class DrawChessTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if ((i % 2 == 0) && (j % 2 == 0) || (i % 2 == 1) && (j % 2 == 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("%");
                }
            }
            System.out.println();
        }
    }
}
