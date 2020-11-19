import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first integer!");
        long number1 = scanner.nextLong();

        System.out.println("Please enter the second integer!");
        long number2 = scanner.nextLong();

        if (number1 > number2) {
            System.out.println(number1);
        } else if (number1 < number2) {
            System.out.println(number2);
        } else {
            System.out.println("The two numbers are equal.");
        }
    }
}
