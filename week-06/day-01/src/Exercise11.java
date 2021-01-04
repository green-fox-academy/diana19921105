import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise11 {
    public static void main(String[] args) {
        randomWiki("wiki.txt");
    }

    public static void randomWiki(String filename) {
        Stream<String> stringStream;

        try {
            stringStream = Files.lines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("File does not exist");
            return;
        }

        stringStream.flatMap(row -> Arrays.stream(row.split(" ")))
                .map(word -> word.replaceAll("\\.|\\s+|\\n|,|\\t|\\d+", ""))
                .map(String::toLowerCase)
                .filter(word -> !word.isEmpty())
                .filter(word -> !hasPunctuationCharacter(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .limit(100)
                .forEach(System.out::println);

    }

    private static boolean hasPunctuationCharacter(String word) {
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(word);
        return matcher.find();

    }
}
