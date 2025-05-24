package ByteByteGo.SlidingWindows;

import java.util.Arrays;

public class SubstringAnagrams {

    public static int countSubstringAnagrams(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength < tLength) return 0;

        int[] expectedFreqArr = new int[26];
        for (char c : t.toCharArray()) expectedFreqArr[c - 'a'] += 1;

        int[] windowFreqArr = new int[26];
        int count = 0;
        int left = 0, right = 0;

        while (right < sLength) {
            windowFreqArr[s.charAt(right) - 'a'] += 1;

            if (right - left + 1 == tLength) {
                if (Arrays.equals(expectedFreqArr, windowFreqArr)) count++;

                windowFreqArr[s.charAt(left) - 'a'] -= 1;
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstringAnagrams("caabab", "aba"));
    }
}
