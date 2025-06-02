package ByteByteGo.BinarySearch;

import java.util.Arrays;

public class FirstAndLastOccurrencesOfANumber {

    public static int[] firstAndLastOccurrencesOfANumber(int[] nums, int target) {
        int lowerBound = lowerBoundBinarySearch(nums, target);
        int upperBound = upperBoundBinarySearch(nums, target);
        return new int[]{ lowerBound, upperBound };
    }

    private static int lowerBoundBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (nums[left] == target) ? left : -1;
    }

    private static int upperBoundBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = ((left + right) / 2) + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
            }
        }
        return (nums[right] == target) ? right : -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstAndLastOccurrencesOfANumber(new int[]{1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11}, 4)));
    }
}
