//Create a function named createPalindrome following your current language's style guide.
// It should take a string, create a palindrome from it and then return it.

public class PalindromeBuilder {
    public static String createPalindrome(String word) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            output.append(word.charAt(i));
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            output.append(word.charAt(i));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(createPalindrome("greenfox"));
        System.out.println(createPalindrome("123"));
    }
}
