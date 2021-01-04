//Write a Stream Expression to find the uppercase characters in a string!

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Exercise6 {
    public static void main(String[] args) {
        String str = "UOVNpptKmR";

        findTheUppercaseChars(str);
    }

    public static void findTheUppercaseChars(String str) {
        Stream<String> stringStream = str.codePoints().mapToObj(c -> String.valueOf((char) c));

        Stream<String> stringStream1 = stringStream.filter(c -> c.matches("[A-Z][^A-Z]*$"));

        stringStream1.forEach(System.out::println);
    }
}
