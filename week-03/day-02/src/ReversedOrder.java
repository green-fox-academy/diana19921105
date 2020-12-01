import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;



public class ReversedOrder {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-order.txt

        reversedOrder("reversedorder.txt");


    }

    private static void reversedOrder(String fileName) {
        try {
            Path filePath = Paths.get("reversedorder.txt");
            Path destination = Paths.get("revorder.txt");
            List<String> lines = Files.readAllLines(filePath);
            StringBuilder newText = new StringBuilder();

            for (int i = lines.size() - 1; i >= 0 ; i--) {
                newText.append(lines.get(i));
                newText.append("\n");
            }

            Files.write(destination, Collections.singleton(newText));
        } catch (IOException e) {
            System.err.println("Could not decrypt the file");
        }
    }
}