import java.util.Arrays;
import java.util.List;

public class ListIntroduction2 {
    public static void main(String[] args) {
        List<String> listA = new java.util.ArrayList<>(List.of("Avocado", "Blueberries", "Durian", "Lychee"));
        List<String> listB = new java.util.ArrayList<>(listA);

        System.out.println(listA);
        System.out.println(listB);

        if (listA.contains("Durian")) {
            System.out.println("List A contains Durian");
        } else {
            System.out.println("Nope");
        }

        listB.remove("Durian");
        listA.add("Kiwifruit");

        System.out.println(listA);
        System.out.println(listB);

        if (listA.size() > listB.size()) {
            System.out.println("List A has more element");
        } else if (listA.size() < listB.size()) {
            System.out.println("List B has more element");
        } else {
            System.out.println("They are equals");
        }

        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i).equals("Avocado")) {
                System.out.println("The index of Avocado is: " + i);
            }
        }
        for (int i = 0; i < listB.size(); i++) {
            if (listB.get(i).equals("Durian")) {
                System.out.println("The index of Durian is: " + i);
            }
        }
        listB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
        System.out.println(listB);

        System.out.println(listA.get(2));
    }
}

