import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        double average;
        int sum;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first integer!");
        int num1 = scanner.nextInt();

        System.out.println("Please enter the second integer!");
        int num2 = scanner.nextInt();

        System.out.println("Please enter the third integer!");
        int num3 = scanner.nextInt();

        System.out.println("Please enter the fourth integer!");
        int num4 = scanner.nextInt();

        System.out.println("Please enter the fifth integer!");
        int num5 = scanner.nextInt();

        sum = num1 + num2 + num3 + num4 + num5;
        average = (double) sum / 5;

        System.out.println("Sum: " + sum + " Average: " + average);

    }
}

