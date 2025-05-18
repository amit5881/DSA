package ByteByteGo.TwoPointers;

public class LongestPalindromicSubstring {

    private static String longestPalindromic(String str) {
        for (int length = str.length(); length > 0; length--) {
            for (int start = 0; start <= str.length() - length; start++) {
                if (isPalindrome(start, start + length, str)) {
                    return str.substring(start, start + length);
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(int i, int j, String str) {
        int left = i;
        int right = j - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromic("babad"));
        System.out.println(longestPalindromic("cbbd"));
    }
}
