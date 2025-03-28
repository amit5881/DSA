package CodingMinutes.DynamicProgramming;

import java.util.Arrays;

public class FibonacciSeries {

    public static int fibonacci(int n, int[] dp) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }

    public static int fibonacci2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci2(2));
    }
}
