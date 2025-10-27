package CrackingTheCodingInterview.ArrayAndStrings;

import java.util.Arrays;

public class CheckPermutation {

    public static boolean checkPermutationArrComparison(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        return Arrays.equals(str1Arr, str2Arr);
    }

    public static boolean checkPermutationAuxiliaryArray(String str1, String str2) {
        int[] freq = new int[26];
        for (char c : str1.toCharArray()) freq[c - 'a']++;
        for (char c : str2.toCharArray()) freq[c - 'a']--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    public static boolean checkPermutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];
        for (char c : s.toCharArray()) letters[c]++;
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(checkPermutationArrComparison(str1, str2));
        System.out.println(checkPermutationAuxiliaryArray(str1, str2));
        System.out.println(checkPermutation(str1, str2));
    }
}
