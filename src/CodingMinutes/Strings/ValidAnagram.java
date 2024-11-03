package CodingMinutes.Strings;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            Character ch = str1.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            Character ch = str2.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) - 1);
        }

        for (int val : count.values()) {
            if (val !=0 ) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
