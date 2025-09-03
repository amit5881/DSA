package ByteByteGo.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCoinCombination {

    public static int minCoinCombinationTopDown(int[] coins, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return topDownDp(coins, target, memo);
    }

    private static int topDownDp(int[] coins, int target, Map<Integer, Integer> memo) {
        if (target == 0) return 0;

        if (memo.containsKey(target)) return memo.get(target);

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= target) {
                minCoins = Math.min(minCoins, 1 + topDownDp(coins, target - coin, memo));
            }
        }
        memo.put(target, minCoins);
        return memo.get(target) > 0 ? memo.get(target) : -1;
    }

    public static int minCoinCombinationBottomUp(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int t = 1; t < target + 1; t++) {
            for (int coin : coins) {
                if (coin <= t) {
                    dp[t] = Math.min(dp[t], 1 + dp[t - coin]);
                }
            }
        }
        return dp[target] > 0 ? dp[target] : -1;
    }

    public static void main(String[] args) {
        System.out.println(minCoinCombinationTopDown(new int[]{ 1, 2, 3 }, 5));
        System.out.println(minCoinCombinationTopDown(new int[]{ 2, 4 }, 5));

        System.out.println();
        System.out.println(minCoinCombinationBottomUp(new int[]{ 1, 2, 3 }, 5));
        System.out.println(minCoinCombinationBottomUp(new int[]{ 2, 4 }, 5));
    }
}
