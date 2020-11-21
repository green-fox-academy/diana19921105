import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number!");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            System.out.print("%");

        }
        System.out.println();
        for (int i = 1; i <= number - 2; i++) {
            for (int j = 1; j <= number; j++) {
                if (j == 1 || j == number) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= number; i++) {
            System.out.print("%");

        }
    }
}

