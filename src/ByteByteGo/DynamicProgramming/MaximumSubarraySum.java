package ByteByteGo.DynamicProgramming;

public class MaximumSubarraySum {

    public static int maximumSubarraySum(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE, currentSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static int maximumSubArraySumDp(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    public static int maximumSumSubArrayDpOptimised(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{3, 1, -6, 2, -1, 4, -9}));
        System.out.println(maximumSubArraySumDp(new int[]{3, 1, -6, 2, -1, 4, -9}));
        System.out.println(maximumSumSubArrayDpOptimised(new int[]{3, 1, -6, 2, -1, 4, -9}));
    }
}
