package CodingMinutes.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static int knapsack(int[] weights, int[] prices, int n, int w) {
        if (n == 0 || w == 0) return 0;

        int inc = 0, exc;
        if (weights[n - 1] <= w) {
            inc = prices[n - 1] + knapsack(weights, prices, n - 1, w - weights[n - 1]);
        }
        exc = knapsack(weights, prices, n - 1, w);
        return Math.max(inc, exc);
    }

    public static int knapsackDp(int[] weights, int[] prices, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                int inc = 0, exc;

                if (weights[n - 1] <= w) {
                    inc = prices[n - 1] + dp[n - 1][w - weights[n - 1]];
                }
                exc = dp[n - 1][w];

                dp[n][w] = Math.max(inc, exc);
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{2,7,3,4}, new int[]{5,20,20,10}, 4, 11));
        System.out.println(knapsackDp(new int[]{2,7,3,4}, new int[]{5,20,20,10}, 4, 11));
    }
}
