import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Exercise9 {
    public static void main(String[] args) {
        String string = "anagram";
        String str = "lambdaCharssss";
        String empty = "";

        frequencyOfCharacters(string);
        frequencyOfCharacters(str);
        frequencyOfCharacters(empty);
    }

    private static void frequencyOfCharacters(String string) {
        Stream<String> stringStream = string.codePoints().mapToObj(c -> String.valueOf((char) c));

        List<Map.Entry<String, Long>> occurrence = stringStream.map(String::toLowerCase)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        System.out.println(occurrence);

    }


}
