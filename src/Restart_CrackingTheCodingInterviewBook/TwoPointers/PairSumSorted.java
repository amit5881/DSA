package Restart_CrackingTheCodingInterviewBook.TwoPointers;

import java.util.Arrays;

public class PairSumSorted {

    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) return new int[] {i , j};
            }
        }
        return new int[]{};
    }

    public static int[] usingTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bruteForce(new int[] {-5, -2, 3, 4, 6}, 7)));
        System.out.println(Arrays.toString(bruteForce(new int[] {1, 1, 1}, 2)));
        System.out.println(Arrays.toString(bruteForce(new int[] {}, 0)));
        System.out.println(Arrays.toString(bruteForce(new int[] {1}, 1)));
        System.out.println(Arrays.toString(bruteForce(new int[] {2, 3}, 5)));
        System.out.println(Arrays.toString(bruteForce(new int[] {2, 4}, 5)));
        System.out.println(Arrays.toString(bruteForce(new int[] {2, 2, 3}, 5)));
        System.out.println(Arrays.toString(bruteForce(new int[] {-1, 2, 3}, 2)));
        System.out.println(Arrays.toString(bruteForce(new int[] {-3, -2, -1}, -5)));

        System.out.println();

        System.out.println(Arrays.toString(usingTwoPointers(new int[] {-5, -2, 3, 4, 6}, 7)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {1, 1, 1}, 2)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {}, 0)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {1}, 1)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {2, 3}, 5)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {2, 4}, 5)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {2, 2, 3}, 5)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {-1, 2, 3}, 2)));
        System.out.println(Arrays.toString(usingTwoPointers(new int[] {-3, -2, -1}, -5)));
    }
}
