import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise7 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        List<String> emptyList = Collections.emptyList();
        stringStartWithGivenLetter(cities, "r");
        stringStartWithGivenLetter(cities, "b");
        stringStartWithGivenLetter(cities, "A");
        stringStartWithGivenLetter(emptyList, "c");
    }

    public static void stringStartWithGivenLetter(List<String> list, String letter) {
        List<String> filteredList = list.stream()
                .filter(strList -> !strList.isEmpty())
                .filter(strList -> findMatch(letter))
                .filter(x -> x.startsWith(letter.toUpperCase()))
                .collect(Collectors.toList());

        System.out.println(filteredList);
    }

    private static boolean findMatch(String letter) {
        Pattern pattern = Pattern.compile("[A-Z][^A-Z]*$");
        Matcher matcher = pattern.matcher(letter);
        return matcher.find();
    }
}
