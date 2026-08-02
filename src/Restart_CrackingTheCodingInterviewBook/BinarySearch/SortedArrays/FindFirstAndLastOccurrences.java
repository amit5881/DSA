package Restart_CrackingTheCodingInterviewBook.BinarySearch.SortedArrays;

import java.util.Arrays;

public class FindFirstAndLastOccurrences {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findFirstAndLastOccurrences(new int[]{1,2,3,4,4,4,5,6,7,8,9,10,11}, 4)));
        System.out.println(Arrays.toString(findFirstAndLastOccurrences(new int[]{5,7,7,8,8,10}, 8)));
    }

    private static int[] findFirstAndLastOccurrences(int[] nums, int target) {
        int lowerBound = findLowerBound(nums, target);
        int upperBound = findUpperBound(nums, target);
        return new int[]{ lowerBound, upperBound };
    }

    private static int findUpperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else left = mid;
        }
        return (nums.length > 0 && nums[right] == target) ? right : -1;
    }

    private static int findLowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return (nums.length > 0 && nums[left] == target) ? left : -1;
    }
}
