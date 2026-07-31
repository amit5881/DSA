package Restart_CrackingTheCodingInterviewBook.SlidingWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {

    public static int longestSubstringWithUniqueCharacters(String str) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < str.length()) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            set.add(str.charAt(right));
            right++;
        }
        return maxLength;
    }

    public static int longestSubstringWithUniqueCharactersOptimised(String str) {
        int maxLen = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            if (map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) >= left) {
                left = map.get(str.charAt(right)) + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(str.charAt(right), right);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithUniqueCharacters("abcba"));
        System.out.println(longestSubstringWithUniqueCharactersOptimised("abcba"));
    }
}
