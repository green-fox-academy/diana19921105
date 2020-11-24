import java.util.ArrayList;
import java.util.List;

public class ListIntroduction {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        for (String name : names) {
            System.out.println(name);
        }

        names.add("William");

        if (names.size() == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list has items");
        }

        names.add("John");
        names.add("Amanda");

        int numberOfElements = 0;
        for (int i = 0; i < names.size(); i++) {
            numberOfElements++;
        }
        System.out.println(numberOfElements);
        System.out.println(names.get(2));

        for (String name : names) {
            System.out.println(name);
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.remove(1);

        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }

        names.removeAll(names);
        System.out.println("The empty list: " + names);
    }
}
