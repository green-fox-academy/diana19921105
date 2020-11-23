// - Create (dynamically*) a two dimensional array
//   with the following matrix**. Use a loop!
//
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1
//
// - Print this two dimensional array to the output

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int row = 4;
        int column = 4;

        int[][] matrix = new int[row][column];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == j) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}
