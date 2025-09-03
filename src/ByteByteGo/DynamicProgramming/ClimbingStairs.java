package ByteByteGo.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbingStairsTopDown(int n) {
        if (n <= 2) return n;

        if (memo.containsKey(n)) return memo.get(n);

        memo.put(n, climbingStairsTopDown(n - 1) + climbingStairsTopDown(n - 2));

        return memo.get(n);
    }

    public static int climbingStairsBottomUp(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbingStairsBottomUpOptimised(int n) {
        if (n <= 2) return n;

        int oneStepBefore = 2;
        int twoStepBefore = 1;

        for (int i = 3; i < n + 1; i++) {
            int current = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = current;
        }
        return oneStepBefore;
    }

    public static void main(String[] args) {
        System.out.println(climbingStairsTopDown(4));
        System.out.println(climbingStairsBottomUp(4));
        System.out.println(climbingStairsBottomUpOptimised(4));
    }
}
