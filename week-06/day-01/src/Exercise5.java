import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        List<Integer> numbersList = Arrays.asList(5, 9, 1, 2);
        List<Integer> negativeNumbers = Arrays.asList(-5, 3, 1, 1);
        List<Integer> emptyList = Collections.emptyList();

        sumOfTheOddNumbers(numbers);
        sumOfTheOddNumbers(numbersList);
        sumOfTheOddNumbers(emptyList);
        sumOfTheOddNumbers(negativeNumbers);
    }

    private static void sumOfTheOddNumbers(List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(x -> x).sum();

        if (numbers.size() == 0) {
            System.out.println("Empty list. Cant get sum!");
        } else {
            System.out.println(sum);
        }

    }
}
