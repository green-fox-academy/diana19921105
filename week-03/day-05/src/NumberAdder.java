//Write a recursive function that takes one parameter: n and
// adds numbers from 1 to n.

public class NumberAdder {
    public static void main(String[] args) {
        System.out.println(numberAdder(10, 0));

    }

    public static int numberAdder(int num, int sum) {
        if (num == 0) {
            return sum;
        }
        sum += num;
        return numberAdder(num - 1, sum);

    }
}
