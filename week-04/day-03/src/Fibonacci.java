public class Fibonacci {

    public static int fibonacci(Integer n) {
        if (n == null) {
            throw new NullPointerException();
        }

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
