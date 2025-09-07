package ByteByteGo.DynamicProgramming;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int longestCommonSubsequenceOptimised(String str1, String str2) {
        int[] prevRow = new int[str2.length() + 1];

        for (int i = str1.length() - 1; i >= 0; i--) {
            int[] currRow = new int[str2.length() + 1];

            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    currRow[j] = 1 + prevRow[j + 1];
                } else {
                    currRow[j] = Math.max(prevRow[j], currRow[j + 1]);
                }
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("acabac", "aebab"));
        System.out.println(longestCommonSubsequenceOptimised("acabac", "aebab"));
    }
}
