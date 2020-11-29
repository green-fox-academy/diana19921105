//Represent the following products with their prices
//
//Product	Amount
//Milk	1.07
//Rice	1.59
//Eggs	3.14
//Cheese	12.60
//Chicken Breasts	9.40
//Apples	2.31
//Tomato	2.58
//Potato	1.75
//Onion	1.10
//Represent Bob's shopping list
//
//Product	Amount
//Milk	3
//Rice	2
//Eggs	2
//Cheese	1
//Chicken Breasts	4
//Apples	1
//Tomato	2
//Potato	1
//Represent Alice's shopping list
//
//Product	Amount
//Rice	1
//Eggs	5
//Chicken Breasts	2
//Apples	1
//Tomato	10
//Create an application which solves the following problems.
//
//How much does Bob pay?
//How much does Alice pay?
//Who buys more Rice?
//Who buys more Potato?
//Who buys more different products?
//Who buys more products? (piece)

import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {

    public static double countSum(double sum, Map<String, Double> prices, Map<String, Integer> list) {
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            Integer quantity = entry.getValue();
            Double price = prices.get(entry.getKey());

            sum += quantity * price;
        }
        return sum;
    }

    public static void main(String[] args) {

        double sumBob = 0;
        double sumAlice = 0;

        Map<String, Double> prices = new HashMap<>();
        prices.put("milk", 1.07);
        prices.put("rice", 1.59);
        prices.put("eggs", 3.14);
        prices.put("cheese", 12.60);
        prices.put("chicken breast", 9.40);
        prices.put("apples", 2.31);
        prices.put("tomato", 2.58);
        prices.put("potato", 1.75);
        prices.put("onion", 1.10);

        Map<String, Integer> bobsList = new HashMap<>();
        bobsList.put("milk", 3);
        bobsList.put("rice", 2);
        bobsList.put("eggs", 2);
        bobsList.put("cheese", 1);
        bobsList.put("chicken breast", 4);
        bobsList.put("apples", 1);
        bobsList.put("tomato", 2);
        bobsList.put("potato", 1);

        Map<String, Integer> aliceList = new HashMap<>();
        aliceList.put("rice", 1);
        aliceList.put("eggs", 5);
        aliceList.put("chicken breast", 2);
        aliceList.put("apples", 1);
        aliceList.put("tomato", 10);

        //how much does bob pay, how much does alice pay
        sumBob = countSum(sumBob, prices, bobsList);
        sumAlice = countSum(sumAlice, prices, aliceList);

        System.out.println(sumBob);
        System.out.println(sumAlice);

        //who buys more rice?
        bobsList.get("rice");
        aliceList.get("rice");
        if (bobsList.get("rice") > aliceList.get("rice")) {
            System.out.println("Bob buys more rice");
        } else if (aliceList.get("rice") > bobsList.get("rice")) {
            System.out.println("Alice buys more rice");
        } else {
            System.out.println("They buy equal quantity of rice");
        }

        //who buys more different products
        if (bobsList.keySet().size() > aliceList.keySet().size()) {
            System.out.println("Bob buys more different product");
        } else {
            System.out.println("Alice buys more different product");
        }

        //who buys more potato?
        Integer bobPotato = bobsList.getOrDefault("potato", 0);
        Integer alicePotato = aliceList.getOrDefault("potato", 0);
        if (bobPotato > alicePotato) {
            System.out.println("Bob buys more potato");
        } else if (alicePotato> bobPotato) {
            System.out.println("Alice buys more potato");
        } else {
            System.out.println("They buy equal quantity of potato");
        }

        //who buys more products(piece)
        int sumBobItem = 0;
        for (int quantity : bobsList.values()) {
            sumBobItem += quantity;
        }

        int sumAliceItem = 0;
        for (int quantity : aliceList.values()) {
            sumAliceItem += quantity;
        }

        if (sumBobItem > sumAliceItem) {
            System.out.println("Bob buys more piece of products");
        } else {
            System.out.println("Alice buys more piece of products");
        }



    }

}
