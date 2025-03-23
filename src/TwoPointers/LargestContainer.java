package TwoPointers;

public class LargestContainer {

    public static int largestContainerBruteForce(int[] heights) {
        int maxWater = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int water = Math.min(heights[i], heights[j]) * (j - i);
                maxWater = Math.max(water, maxWater);
            }
        }
        return maxWater;
    }

    public static int largestContainerOptimised(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int water = Math.min(heights[left], heights[right]) * (right - left);
            maxWater = Math.max(maxWater, water);

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(largestContainerBruteForce(new int[] {2,7,8,3,7,6}));
        System.out.println(largestContainerBruteForce(new int[] {4,1,3}));
        System.out.println("===Optimised===");
        System.out.println(largestContainerOptimised(new int[]{}));
        System.out.println(largestContainerOptimised(new int[]{1}));
        System.out.println(largestContainerOptimised(new int[]{0,1,0}));
        System.out.println(largestContainerOptimised(new int[]{3,3,3,3}));
        System.out.println(largestContainerOptimised(new int[]{1,2,3}));
        System.out.println(largestContainerOptimised(new int[]{3,2,1}));
    }
}
