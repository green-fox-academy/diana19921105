//  Create a function that takes a list of numbers as a parameter
//  Returns a list of numbers where every number in the list occurs only once

//  Example
//  System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
//  should print: `[1, 11, 34, 52, 61]`


import java.util.ArrayList;
import java.util.List;

public class Unique {
    public static List<Integer> unique(int[] numbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!sortedNumbers.contains(numbers[i])) {
                    sortedNumbers.add(numbers[i]);
                }
            }
        }
        return sortedNumbers;
    }


    public static void main(String[] args) {
        System.out.println(unique(new int[]{1, 11, 52, 84, 52, 11, 67, 1}));
    }
}
