package Dump.CrackingTheCodingInterview;

import java.util.Arrays;

public class StringHasUniqueChars {

    // extra space
    public static boolean stringHasUnique(String str) {
        int[] chars = new int[256];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i)]++;
        }

        for (int aChar : chars) {
            if (aChar > 1) return false;
        }

        return true;
    }

    // no space
    public static boolean noSpace(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        for (int i = 1; i < sorted.length(); i++) {
            if (sorted.charAt(i - 1) == sorted.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(noSpace("abc"));
    }
}
