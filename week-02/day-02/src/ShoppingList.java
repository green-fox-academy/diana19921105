//We are going to represent a shopping list in a list containing strings.
//
//Create a list with the following items.
//Eggs, milk, fish, apples, bread and chicken
//Create an application which solves the following problems.
//Do we have milk on the list?
//Do we have bananas on the list?

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>();
        shoppingList = List.of("eggs", "milk", "fish", "apples", "bread", "chicken");

       if (shoppingList.contains("milk")) {
           System.out.println("We have milk on the list");
       } else {
           System.out.println("We don't have milk on the list");
       }
       if (shoppingList.contains("banana")) {
           System.out.println("We have banana on the list");
       } else {
           System.out.println("We don't have banana on the list");
       }
    }
}
