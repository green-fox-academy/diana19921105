// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0


import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int divisor = scanner.nextInt();
        int divider = 10;
        int result = 0;

        try {
            result = divider / divisor;
        } catch (ArithmeticException exception) {
            System.err.println("Can't divide by zero");
        }
    
        if (divisor != 0) {
            System.out.println(result);
        }
    }
}



