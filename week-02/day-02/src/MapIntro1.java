import java.util.HashMap;
import java.util.Map;

public class MapIntro1 {
    public static void main(String[] args) {
        Map<Integer, Character> newHashmap = new HashMap<>();

        if (newHashmap.size() == 0) {
            System.out.println("Empty map");
        } else {
            System.out.println("Not empty");
        }

        newHashmap.put(97, 'a');
        newHashmap.put(98, 'b');
        newHashmap.put(99, 'c');
        newHashmap.put(65, 'A');
        newHashmap.put(66, 'B');
        newHashmap.put(67, 'C');


        System.out.println(newHashmap.keySet());
        System.out.println(newHashmap.values());

        newHashmap.put(68, 'D');

        System.out.println(newHashmap.size());

        String valueOf99 = "The value of the number 99 is: " + newHashmap.get(99);
        System.out.println(valueOf99);

        newHashmap.remove(97);

        if (newHashmap.containsKey(100)) {
            System.out.println("There is an associated value with key 100");
        } else {
            System.out.println("Nope");
        }

        newHashmap.clear();
        System.out.println("newHashmap after remove all key-value pairs: " + newHashmap);
    }
}



