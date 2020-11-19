public class Swap {
    public static void main(String[] args) {

        int a = 123;
        int b = 526;

        int temporary = a;
        a = b;
        b = temporary;

        System.out.println(a);
        System.out.println(b);
    }
}
