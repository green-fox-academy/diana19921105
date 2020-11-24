//We are going to represent our products in a map where the keys are strings representing the product's name and the values are numbers representing the product's price.
//
//        Create a map with the following key-value pairs.
//
//        Product name (key)	Price (value)
//        Eggs	200
//        Milk	200
//        Fish	400
//        Apples	150
//        Bread	50
//        Chicken	550
//        Create an application which solves the following problems.
//
//        How much is the fish?
//        What is the most expensive product?
//        What is the average price?
//        How many products' price is below 300?
//        Is there anything we can buy for exactly 125?
//        What is the cheapest product?

import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    public static void main(String[] args) {
        Map<String, Integer> database = new HashMap<>();

        database.put("eggs", 200);
        database.put("milk", 200);
        database.put("fish", 400);
        database.put("apples", 150);
        database.put("bread", 50);
        database.put("chicken", 550);

        String mostExpensiveProduct = "";
        int mostExpensive = Integer.MIN_VALUE;
        long sum = 0;
        double average = 0;
        int numberOfPriceUnder300 = 0;
        StringBuilder thingExactlyCost125 = new StringBuilder();
        String cheapestProduct = "";
        int cheapest = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : database.entrySet()) {
            if (entry.getKey().equals("fish")) {
                System.out.println("The fish costs: " + entry.getValue());
            }
            if (entry.getValue() > mostExpensive) {
                mostExpensive = entry.getValue();
                mostExpensiveProduct = entry.getKey();
            }

            sum += entry.getValue();
            average = (double) sum / database.size();

            if (entry.getValue() < 300) {
                numberOfPriceUnder300++;
            }

            if (entry.getValue() == 125) {
                thingExactlyCost125.append(entry.getKey());
            }

            if (entry.getValue() < cheapest) {
                cheapest = entry.getValue();
                cheapestProduct = entry.getKey();
            }
        }
        System.out.println("The most expensive product is: " + mostExpensiveProduct);
        System.out.println("The average price is: " + average);
        System.out.println("The number of products' the price under 300 is: " + numberOfPriceUnder300);
        System.out.println("We can buy for exactly 125: " + thingExactlyCost125);
        System.out.println("The cheapest product is: " + cheapestProduct);
    }
}
