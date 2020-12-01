// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file name!");
        String name = scanner.nextLine();
        int numberOfLines = 0;

        Path filePath = Paths.get(name);
        try {

            List<String> lines = Files.readAllLines(filePath);
            for (int i = 0; i < lines.size(); i++) {
                numberOfLines++;
            }
            System.out.println(numberOfLines);
        } catch (Exception e) {
            System.err.println(0);
        }
    }
}
