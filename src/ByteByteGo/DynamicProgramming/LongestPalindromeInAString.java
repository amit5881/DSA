package ByteByteGo.DynamicProgramming;

public class LongestPalindromeInAString {

    public static String longestPalindromeInAString(String str) {
        int n = str.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                startIndex = i;
            }
        }

        for (int substringLength = 3; substringLength < n + 1; substringLength++) {
            for (int i = 0; i < n - substringLength + 1;  i++) {
                int j = i + substringLength - 1;

                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = substringLength;
                    startIndex = i;
                }
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }

    public static String longestPalindromicSubstringOptimised(String str) {
        int n = str.length();
        int start = 0;
        int maxLength = 0;

        for (int centre = 0; centre < n; centre++) {
            int[] oddStartAndLength = expandPalindrome(centre, centre, str);
            int oddStart = oddStartAndLength[0];
            int oddLength = oddStartAndLength[1];
            if (oddLength > maxLength) {
                start = oddStart;
                maxLength = oddLength;
            }

            if (centre < n - 1 && str.charAt(centre) == str.charAt(centre + 1)) {
                int[] evenStartAndLength = expandPalindrome(centre, centre + 1, str);
                int evenStart = evenStartAndLength[0];
                int evenLength = evenStartAndLength[1];
                if (evenLength > maxLength) {
                    start = evenStart;
                    maxLength = evenLength;
                }
            }
        }
        return str.substring(start, start + maxLength);
    }

    private static int[] expandPalindrome(int left, int right, String str) {
        while (left > 0 && right < str.length() - 1 && str.charAt(left - 1) == str.charAt(right + 1)) {
            left--;
            right++;
        }
        return new int[] { left, right - left + 1 };
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeInAString("abccbaba"));
        System.out.println(longestPalindromicSubstringOptimised("abccbaba"));
    }
}
