import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        double average;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Please enter the " + i + " st integer!");
            int num = scanner.nextInt();
            sum += num;
        }

        average = (double) sum / 5;

        System.out.println("Sum: " + sum + " Average: " + average);

    }
}

