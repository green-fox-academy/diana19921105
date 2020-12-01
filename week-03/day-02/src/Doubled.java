import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Doubled {

    public static void main(String[] args) throws IOException {
        // Create a method that decrypts the duplicated-chars.txt
        decrypt("doubled.txt");

    }

    private static void decrypt(String fileName) throws IOException {
        try {
            Path filePath = Paths.get("doubled.txt");
            Path destination = Paths.get("dest.txt");
            List<String> lines = Files.readAllLines(filePath);
            StringBuilder text = new StringBuilder();

            for (String line : lines) {
                for (int i = 0; i < line.length(); i += 2) {
                    text.append(line.charAt(i));
                }
                text.append("\n");
            }

            Files.write(destination, Collections.singleton(text));
        }catch (IOException exception) {
            System.err.println("Could not decrypt the file");
        }
    }
}