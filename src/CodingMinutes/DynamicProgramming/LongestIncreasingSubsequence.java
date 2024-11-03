package CodingMinutes.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int longestCommonSubsequnce(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequnce(new int[]{50,4,10,8,30,100}));
    }
}
