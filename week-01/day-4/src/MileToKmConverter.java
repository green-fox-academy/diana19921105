import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of miles!");
        double userInput = scanner.nextDouble();

        double kilometers = userInput * 1.609344;

        System.out.println(userInput + " miles is: " + kilometers + " kilometers");
    }
}
