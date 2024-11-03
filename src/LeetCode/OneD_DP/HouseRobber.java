package LeetCode.OneD_DP;

import java.util.Arrays;

public class HouseRobber {

    public static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

    static int[] memo;

    public static int rob2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob2(nums, nums.length - 1);
    }

    private static int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
        memo[i] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{1, 2, 3, 1}));
    }
}
