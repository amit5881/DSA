package CodingMinutes.DynamicProgramming.Practise;

import java.util.HashMap;

public class ClimbStairs {

    public static int climbStairsRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public static int climbStairsDp(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) return 1;
        if (!memo.containsKey(n)) memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairsRecursive(2));
        System.out.println(climbStairsDp(45));
    }
}
