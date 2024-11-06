package Strings;

public class StringCompressionIII {

    /*
    Input: word = "abcde"

    Output: "1a1b1c1d1e"
     */
    public static String stringCompression(String word) {
        int wordCount = 1;
        StringBuilder result = new StringBuilder();
        char ch = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == ch && wordCount < 9) {
                wordCount++;
            } else {
                result.append(wordCount).append(ch);
                ch = word.charAt(i);
                wordCount = 1;
            }
        }
        result.append(wordCount).append(ch);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("abcde"));
        System.out.println(stringCompression("aaaaaaaaaaaaaabb"));
    }
}
