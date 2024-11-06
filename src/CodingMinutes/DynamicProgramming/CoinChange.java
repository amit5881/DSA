package CodingMinutes.DynamicProgramming;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] minCoinDp = new int[amount + 1];
        minCoinDp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            minCoinDp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && minCoinDp[i - coin] != Integer.MAX_VALUE) {
                    minCoinDp[i] = Math.min(minCoinDp[i], minCoinDp[i - coin] + 1);
                }
            }
        }
        return minCoinDp[amount] == Integer.MAX_VALUE ? -1 : minCoinDp[amount];
    }

    public static int coinChangeNew(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 5, 6, 9 }, 11));
        System.out.println(coinChangeNew(new int[] { 5, 6, 9 }, 11));
    }
}
