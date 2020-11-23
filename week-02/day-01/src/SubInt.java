//  Create a function that takes a number and an array of integers as a parameter
//  Returns the indices of the integers in the array of which the first number is a part of
//  Or returns an empty array if the number is not part of any of the integers in the array

//  Example:
//    System.out.println(Arrays.toString(subInt(1, new int[] {1, 11, 34, 52, 61})));
//            //  should print: `[0, 1, 4]`
//            System.out.println(Arrays.toString(subInt(9, new int[] {1, 11, 34, 52, 61})));
//  should print: '[]'

// Note: We are using Arrays.toString() function as a way to print
// array returned from subInt(). You could just as well iterate over array to print it.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubInt {

    public static Integer[] subInt(int number, int[] arr) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String str = Integer.toString(arr[i]);
            if (str.contains(Integer.toString(number))) {
                indices.add(i);
            }
        }
        Integer[] result = new Integer[indices.size()];
        return indices.toArray(result);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subInt(1, new int[]{1, 11, 52, 110})));
        System.out.println(Arrays.toString(subInt(8, new int[]{1, 11, 52, 110})));
        System.out.println(Arrays.toString(subInt(5, new int[]{1, 11, 52, 110})));
    }
}