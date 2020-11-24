//We are going to represent our contacts in a map where the keys are going to be strings and the values are going to be strings as well.
//
//        Create a map with the following key-value pairs.//
//        Name (key)	Phone number (value)
//        William A. Lathan	405-709-1865
//        John K. Miller	402-247-8568
//        Hortensia E. Foster	606-481-6467
//        Amanda D. Newland	319-243-5613
//        Brooke P. Askew	307-687-2982
//        Create an application which solves the following problems.
//
//        What is John K. Miller's phone number?
//        Whose phone number is 307-687-2982?
//        Do we know Chris E. Myers' phone number?

import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    public static void main(String[] args) {
        Map<String, String> telephoneBook = new HashMap<>();

        telephoneBook.put("William A. Lathan", "405-709-1865");
        telephoneBook.put("John K. Miller", "402-247-8568");
        telephoneBook.put("Hortensia E. Foster", "606-481-6467");
        telephoneBook.put("Amanda D. Newland", "319-243-5613");
        telephoneBook.put("Brooke P. Askew", "307-687-2982");

        for (Map.Entry<String, String> entry : telephoneBook.entrySet()) {
            if (entry.getKey().equals("John K. Miller")) {
                System.out.println("John K. Miller telephon number is: " + entry.getValue());
            }
            if (entry.getValue().equals("307-687-2982")) {
                System.out.println("The number 307-687-2982 is " + entry.getKey() + "'s phone number");
            }
        }
        if (telephoneBook.containsKey("Chris E. Myers")) {
            System.out.println("We know Chris E. Myers' phone number");
        } else {
            System.out.println("We don't know Chris E. Myers phone number");
        }
    }
}
