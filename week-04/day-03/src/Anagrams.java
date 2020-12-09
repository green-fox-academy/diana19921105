public class Anagrams {

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
