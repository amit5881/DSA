package Restart_CrackingTheCodingInterviewBook.SlidingWindows;

import java.util.Arrays;

public class SubstringAnagrams {

    public static int substringAnagrams(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[] expected = new int[26];
        for (char c : t.toCharArray()) expected[c - 'a']++;
        int left = 0, right = 0;
        int count = 0;
        int[] window = new int[26];
        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;
            if (right - left + 1 == t.length()) {
                if (Arrays.equals(expected, window)) count++;
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(substringAnagrams("caabab", "aba"));
    }
}
