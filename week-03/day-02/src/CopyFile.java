// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful
//

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {

        System.out.println(copyFile("original.txt", "dest.txt"));
    }

    private static boolean copyFile(String original, String destination) {

        try {
            Path filePath = Paths.get(original);
            Path copyFile = Paths.get(destination);
            List<String> lines = Files.readAllLines(filePath);
            StringBuilder copy = new StringBuilder();
            for (String line : lines) {
                copy.append(line);
                copy.append("\n");
            }
            Files.write(copyFile, Collections.singleton(copy));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
