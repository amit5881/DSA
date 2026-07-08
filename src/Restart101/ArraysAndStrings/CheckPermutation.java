package Restart101.ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {

    public static boolean unique1(String s, String t) {
        if (s.length() != t.length()) return false;

        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }

    private static boolean unique2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];

        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(unique1("pen", "ner"));
        System.out.println(unique2("pen", "nep"));
    }
}
