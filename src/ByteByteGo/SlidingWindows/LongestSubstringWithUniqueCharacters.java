package ByteByteGo.SlidingWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {

    // Brute Force O(n²)
    public static int longestSubstringWithUniqueCharactersBrute(String str) {
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                if (allUniqueChars(subString)) {
                    maxLength = Math.max(maxLength, subString.length());
                }
            }
        }
        return maxLength;
    }

    private static boolean allUniqueChars(String subString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < subString.length(); i++) {
            if (!set.add(subString.charAt(i))) return false;
        }
        return true;
    }

    // Better solution O(n)
    public static int longestSubstringWithUniqueCharactersBetter(String str) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < str.length()) {
            // shrink the window
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            set.add(str.charAt(right));

            // expand the window
            right++;
        }
        return maxLength;
    }

    // Optimised
    public static int longestSubstringWithUniqueCharactersOptimised(String str) {
        int maxLength = 0;
        Map<Character, Integer> prevIndex = new HashMap<>();
        int left = 0, right = 0;

        while (right < str.length()) {
            if (prevIndex.containsKey(str.charAt(right)) && prevIndex.get(str.charAt(right)) >= left) {
                left = prevIndex.get(str.charAt(right)) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            prevIndex.put(str.charAt(right), right);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithUniqueCharactersBrute("abcba"));
        System.out.println(longestSubstringWithUniqueCharactersBetter("abcba"));
        System.out.println(longestSubstringWithUniqueCharactersOptimised("abcba"));
    }
}
