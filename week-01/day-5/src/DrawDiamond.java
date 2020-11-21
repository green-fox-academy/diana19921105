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

public class DrawDiamond {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i += 2) {
            for (int numberOfSpaces = 1; numberOfSpaces <= (7 - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int numberOfSpaces = 1; numberOfSpaces <= (7 - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 5; i >= 1; i -= 2) {
            for (int numberOfSpaces = 1; numberOfSpaces <= (5 - i) / 2 + 1; numberOfSpaces++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            for (int numberOfSpaces = 1; numberOfSpaces <= (5 - i) / 2; numberOfSpaces++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
