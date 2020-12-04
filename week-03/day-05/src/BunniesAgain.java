// We have bunnies standing in a line,
// numbered 1, 2, 3, 4, ...
// The odd bunnies (1, 3, ...) have the normal 2 ears.
// The even bunnies (2, 4, ..) we'll say have 3 ears,
// because they each have a raised foot.
// Recursively return the number of "ears" in
// the bunny line 1, 2, ... n (without loops or multiplication).

public class BunniesAgain {
    public static void main(String[] args){
        System.out.println(bunnies(10));
        System.out.println(bunnies(5));
    }

    public static int bunnies(int numberOfBunnies) {
        if (numberOfBunnies == 0) {
            return numberOfBunnies;
        }
        if (numberOfBunnies % 2 == 1) {
            return bunnies(numberOfBunnies - 1) + 2;
        } else {
            return bunnies(numberOfBunnies - 1) + 3;
        }
    }
}
