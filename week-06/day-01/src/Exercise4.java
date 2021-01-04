import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class Exercise4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        List<Integer> numbersList = Arrays.asList(1, 3, 2);
        List<Integer> emptyList = Collections.emptyList();

        countAverage(numbers);
        countAverage(numbersList);
        countAverage(emptyList);
    }

    private static void countAverage(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x).average();

        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        } else {
            System.out.println("Cant get average!");
        }
    }
}
