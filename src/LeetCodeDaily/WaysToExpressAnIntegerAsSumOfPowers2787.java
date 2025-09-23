package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToExpressAnIntegerAsSumOfPowers2787 {

    public static int MOD = 1_000_000_007;

    public static int waysToExpress(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow(i, x);
            if (power <= n) {
                powers.add(power);
            } else break;
        }

        int[][] dp = new int[n + 1][powers.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(dp, powers, n, 0);
    }

    private static int helper(int[][] dp, List<Integer> powers, int target, int index) {
        if (target == 0) return 1;
        if (index == powers.size()) return 0;
        if (dp[target][index] != -1) return dp[target][index];

        int total = 0;
        if (powers.get(index) <= target) {
            total = helper(dp, powers, target - powers.get(index), index + 1);
        }
        total = (total + helper(dp, powers, target, index + 1) % MOD);

        return dp[target][index] = total;
    }

    public static void main(String[] args) {
        System.out.println(waysToExpress(10, 2));
        System.out.println(waysToExpress(4, 1));
    }
}
