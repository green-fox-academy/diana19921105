//String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
//
//        // When saving this quote a disk error has occurred. Please fix it.
//        // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
//        // Using pieces of the quote variable (instead of just redefining the string)
//
//        System.out.println(quote);


public class TakesLonger {
    public static void main(String[] args) {
        String result = "";
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
        String toBeInsert = "always takes longer than ";
        int startIndex = 20;

        for (int i = 0; i < quote.length(); i++) {
            result += quote.charAt(i);
            if (i == startIndex) {
                result += toBeInsert;
            }
        }
        System.out.println(result);
    }
}
