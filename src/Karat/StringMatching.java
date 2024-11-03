package Karat;

import java.util.HashMap;

public class StringMatching {

    public static HashMap<Character, Integer> getCharCount(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static String find(String[] words, String note) {
        HashMap<Character, Integer> noteCharCount = getCharCount(note);

        for (String word : words) {
            HashMap<Character, Integer> wordCharCount = getCharCount(word);

            boolean canFromWord = true;
            for (char c : wordCharCount.keySet()) {
                if (noteCharCount.getOrDefault(c, 0) < wordCharCount.get(c)) {
                    canFromWord = false;
                }
            }
            if (canFromWord) {
                return word;
            }
        }

        return "-";
    }

    public static void main(String[] args) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        String note1 = "ctay";
        System.out.println(find(words, note1));
    }
}
