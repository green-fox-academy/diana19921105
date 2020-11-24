//We are going to represent our expenses in a list containing integers.
//
//Create a list with the following items.
//500, 1000, 1250, 175, 800 and 120
//Create an application which solves the following problems.
//How much did we spend?
//Which was our greatest expense?
//Which was our cheapest spending?
//What was the average amount of our spendings?

import java.util.ArrayList;
import java.util.List;

public class PersonalFinance {
    public static void main(String[] args) {
        List<Integer> spendings = new ArrayList<>();
        spendings = List.of(500, 1000, 1250, 175, 800, 120);

        int allSpending = 0;
        int greatestExpense = Integer.MIN_VALUE;
        int cheapestSending = Integer.MAX_VALUE;
        double average = 0;

        for (int i = 0; i < spendings.size(); i++) {
            allSpending += spendings.get(i);
            if (spendings.get(i) > greatestExpense) {
                greatestExpense = spendings.get(i);
            }
            if (spendings.get(i) < cheapestSending) {
                cheapestSending = spendings.get(i);
            }
            average = (double) allSpending / spendings.size();
        }
        System.out.println(allSpending);
        System.out.println(greatestExpense);
        System.out.println(cheapestSending);
        System.out.println(average);
    }
}
