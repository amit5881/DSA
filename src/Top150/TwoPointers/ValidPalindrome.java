package Top150.TwoPointers;

import java.util.Locale;

public class ValidPalindrome {

    public static boolean isValidPalindrome(String str) {
        if (str.isEmpty()) return true;

        str = str.replaceAll("[^A-Za-z0-9]", "");

        str = str.toLowerCase();

        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public static boolean isValidPalindromeOptimised(String str) {
        if (str.isEmpty()) return true;

        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            char currStart = str.charAt(start);
            char currEnd = str.charAt(end);

            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindromeOptimised("race a car"));
    }
}
