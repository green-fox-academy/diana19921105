public class Power {
    public static void main(String[] args) {
        System.out.println(power(3, 4));
    }

    public static int power(int base, int raise) {
        if (raise == 1) {
            return base;
        }
        return base * power(base, raise - 1);
    }
}
