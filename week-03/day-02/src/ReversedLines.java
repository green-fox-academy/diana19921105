import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReversedLines {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt

        reversed("reversed.txt");


    }

    private static void reversed(String fileName) {
        try {
            Path filePath = Paths.get("reversed.txt");
            Path destination = Paths.get("destination.txt");
            List<String> lines = Files.readAllLines(filePath);
            StringBuilder newText = new StringBuilder();

            for (String line : lines) {
                for (int i = line.length() - 1; i >= 0; i--) {
                    newText.append(line.charAt(i));
                }
                newText.append("\n");
            }
            Files.write(destination, Collections.singleton(newText));
        } catch (IOException e) {
            System.err.println("Could not decrypt the file");
        }
    }
}
