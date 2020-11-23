// - Create an array variable named `numbers`
//   with the following content: `[54, 23, 66, 12]`
// - Print the sum of the second and the third element

public class SumElements {
    public static void main(String[] args) {
        int[] numbers = {54, 23, 66, 12};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = numbers[1] + numbers[2];
        }
        System.out.println(sum);
    }
}
