package LeetCode.OneD_DP;

import java.util.Arrays;

public class Tribonacci {

    public static int tribonacci(int n) {
        int[] dp = new int[50];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(0));
    }
}
