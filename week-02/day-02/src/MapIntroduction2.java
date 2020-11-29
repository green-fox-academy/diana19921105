import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {
    public static void main(String[] args) {
        Map<String, String> library = new HashMap<>();

        library.put("978-1-60309-452-8", "A Letter to Jo");
        library.put("978-1-60309-459-7", "Lupus");
        library.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        library.put("978-1-60309-461-0", "The Lab");

        for (Map.Entry<String, String> entry : library.entrySet()) {
            System.out.println(entry.getValue() + " (ISBN: " + entry.getKey() + ")");
        }

        //Remove the key-value pair with key 978-1-60309-444-3
        library.remove("978-1-60309-444-3");


        //Remove the key-value pair with value The Lab
        for (String isbn : library.keySet()) {
            if (library.get(isbn).equals("The Lab")) {
                library.remove(isbn);
            }
        }

        System.out.println(library);


        library.put("978-1-60309-450-4", "They Called Us Enemy");
        library.put("978-1-60309-453-5", "Why Did We Trust Him?");

        if (library.containsKey("478-0-61159-424-8")) {
            System.out.println("There is an associated value with key 478-0-61159-424-8");
        } else {
            System.out.println("Nope");
        }

        //Print the value associated with key 978-1-60309-453-5
        System.out.println("The value of the key 978-1-60309-453-5 is: " + library.get("978-1-60309-453-5"));
    }
}


