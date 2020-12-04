public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(8));

    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
