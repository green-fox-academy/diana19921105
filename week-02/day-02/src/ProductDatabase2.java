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
//        Which products cost less than 201? (just the name)
//        Which products cost more than 150? (name + price)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {

        List<String> lessThan201 = new ArrayList<>();
        Map<String, Integer> costMoreThan150 = new HashMap<>();

        Map<String, Integer> database = new HashMap<>();
        database.put("eggs", 200);
        database.put("milk", 200);
        database.put("fish", 200);
        database.put("apples", 200);
        database.put("bread", 200);
        database.put("chicken", 200);

        for (Map.Entry<String, Integer> entry : database.entrySet()) {
            if (entry.getValue() < 201) {
                lessThan201.add(entry.getKey());
            }

            if (entry.getValue() > 150) {
                costMoreThan150.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(lessThan201);
        System.out.println(costMoreThan150);
    }


}
