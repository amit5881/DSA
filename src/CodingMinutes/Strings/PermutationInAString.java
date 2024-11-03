package CodingMinutes.Strings;

import java.util.HashMap;

public class PermutationInAString {

    public static boolean checkInclusion(String str1, String str2) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        }

        for (int val : charCount.values()) {
            if (val != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("test", "ttew"));
    }
}
