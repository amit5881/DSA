package LeetCodeDaily;

public class TrappingRainWater42 {

    public static int bruteForce(int[] heights) {
        int water = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }
            int rightMax = 0;
            for (int j = i; j < heights.length; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }
            water += Math.min(leftMax, rightMax) - heights[i];
        }
        return water;
    }

    public static int betterApproach(int[] heights) {
        int ans = 0;
        int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        int[] rightMax = new int[heights.length];
        rightMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        for (int i = 0; i < heights.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return ans;
    }

    public static int optimalApproach(int[] height) {
        int ans = 0, l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                ans += lMax - height[l++];
            } else  {
                ans += rMax - height[r--];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(bruteForce(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(betterApproach(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(betterApproach(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(optimalApproach(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(optimalApproach(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
