import java.util.ArrayList;
import java.util.List;

public class PalindromeSearcher {

    private static boolean isPalindrome(String str) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedWord.append(str.charAt(i));
        }
        return reversedWord.toString().equals(str);
    }

    private static List<String> searchPalindrome(String word) {
        List<String> palindromes = new ArrayList<>();

        for (int i = 3; i <= word.length(); i++) {
            for (int j = 0; j < word.length() - i; j++) {
                String substring = word.substring(j, j + i);
                if (isPalindrome(substring)) {
                    palindromes.add(substring);
                }
            }
        }

        return palindromes;
    }


    public static void main(String[] args) {
        System.out.println(searchPalindrome("dog goat dad duck doodle never"));
        System.out.println(searchPalindrome("apple"));
    }

}
