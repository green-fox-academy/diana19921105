//We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears
// across all the bunnies recursively (without loops or multiplication).

public class Bunnies {
    public static void main(String[] args) {
        System.out.println(bunnies(10));
        System.out.println(bunnies(100));
    }

    public static int bunnies(int numberOfBunny) {
        if (numberOfBunny == 0) {
            return numberOfBunny;
        }
        return bunnies(numberOfBunny - 1) + 2;
    }
}
