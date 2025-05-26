package ByteByteGo.SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacement {

    public static int longestUniformSubstringAfterReplacement(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int highestFrequency = 0, maxLength = 0;
        int right = 0, left = 0;

        while (right < str.length()) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
            highestFrequency = Math.max(highestFrequency, map.get(str.charAt(right)));

            int numbsOfCharsToReplaced = (right - left + 1) - highestFrequency;

            if (numbsOfCharsToReplaced > k) {
                map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                left++;
            }

            maxLength = right - left + 1;
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestUniformSubstringAfterReplacement("aabcdcca", 2));
    }
}
