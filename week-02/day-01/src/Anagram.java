// Create a function named isAnagram following your current language's style guide.
// It should take two strings and return a boolean value depending on whether its an anagram or not.

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("dog", "god"));
        System.out.println(isAnagram("fried", "fired"));
        System.out.println(isAnagram("green", "fox"));

    }


    public static boolean isAnagram(String wordFrom, String wordTo) {
        for (int i = 0; i < wordFrom.length(); i++) {
            int indexOf = wordTo.indexOf(wordFrom.charAt(i));
            if (indexOf != -1) {
                wordTo = wordTo.substring(0, indexOf) + wordTo.substring(indexOf + 1);
            } else {
                return false;
            }
        }

        return wordTo.equals("");
    }

}
