package ByteByteGo.DynamicProgramming;

public class Knapsack {

    public static int knapsack(int cap, int[] weights, int[] values) {
        int[][] dp = new int[values.length + 1][cap + 1];

        for (int i = values.length - 1; i >= 0; i--) {
            for (int c = 1; c < cap + 1; c++) {
                if (weights[i] <= c) {
                    dp[i][c] = Math.max(values[i] + dp[i + 1][c - weights[i]], dp[i + 1][c]);
                } else {
                    dp[i][c] = dp[i + 1][c];
                }
            }
        }
        return dp[0][cap];
    }

    public static int knapsackOptimised(int cap, int[] weights, int[] values) {
        int n = values.length;

        int[] prevRow = new int[cap + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] currRow = new int[cap + 1];
            for (int c = 1; c < cap + 1; c++) {
                if (weights[i] <= c) {
                    currRow[c] = Math.max(values[i] + prevRow[c - weights[i]], prevRow[c]);
                } else {
                    currRow[c] = prevRow[c];
                }
            }
            prevRow = currRow;
        }
        return prevRow[cap];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(7, new int[]{ 5, 3, 4, 1 }, new int[] {70, 50, 40, 10}));
        System.out.println(knapsackOptimised(7, new int[]{ 5, 3, 4, 1 }, new int[] {70, 50, 40, 10}));
    }
}
