import java.util.Arrays;

public class MaximumFinder {
    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 9, 67, 1};
        System.out.println(maximum(nums, 5));
    }

    public static int maximum(int[] numbers, int i) {
        if (i == 0) {
            return numbers[0];
        }
        return Math.max(numbers[i], maximum(numbers, i - 1));
    }
}
