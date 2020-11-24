import java.util.HashMap;
import java.util.Map;

public class MapIntroducton2 {
    public static void main(String[] args) {
        Map<String, String> hashmap = new HashMap<>();

        hashmap.put("978-1-60309-452-8", "A Letter to Jo");
        hashmap.put("978-1-60309-459-7", "Lupus");
        hashmap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        hashmap.put("978-1-60309-461-0", "The Lab");

        for (Map.Entry<String, String> entry : hashmap.entrySet()) {
            System.out.println(entry.getValue() + " (ISBN: " + entry.getKey() + ")");
        }

        hashmap.remove("978-1-60309-444-3");

        //Remove the key-value pair with value The Lab

        hashmap.put("978-1-60309-450-4", "They Called Us Enemy");
        hashmap.put("978-1-60309-453-5", "Why Did We Trust Him?");

        if (hashmap.containsKey("478-0-61159-424-8")) {
            System.out.println("There is an associated value with key 478-0-61159-424-8");
        } else {
            System.out.println("Nope");
        }

      for(Map.Entry<String, String> entry : hashmap.entrySet()) {
          if (entry.getKey().equals("978-1-60309-453-5")) {
              System.out.println(entry.getValue());
          }
      }
    }
}


