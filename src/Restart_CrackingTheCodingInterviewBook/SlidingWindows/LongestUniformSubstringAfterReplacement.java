package Restart_CrackingTheCodingInterviewBook.SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacement {

    public static int longestUniformSubstringAfterReplacement(String str, int k) {
        int left = 0, right = 0, highestFrequency = 0, maxLen = 0;
        Map<Character, Integer> frequency = new HashMap<>();
        while (right < str.length()) {
            frequency.put(str.charAt(right), frequency.getOrDefault(str.charAt(right), 0) + 1);
            highestFrequency = Math.max(highestFrequency, frequency.get(str.charAt(right)));
            int numOfCharsToReplace = (right - left + 1) - highestFrequency;
            if (numOfCharsToReplace > k) {
                frequency.put(str.charAt(left), frequency.get(str.charAt(left)) - 1);
                left++;
            }
            maxLen = right - left + 1;
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestUniformSubstringAfterReplacement("aabcdcca", 2));
    }
}
