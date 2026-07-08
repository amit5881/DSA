package Restart_CrackingTheCodingInterviewBook.TwoPointers;

import java.util.Arrays;

public class ShiftZerosToTheEnd {

    public static int[] shiftZerosToTheEnd(int[] nums) {
        int[] temp = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[i++] = num;
            }
        }
        for (int j = 0; j < temp.length; j++) {
            nums[j] = temp[j];
        }
        return nums;
    }

    public static int[] shiftZerosToTheEndOptimised(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) swap(nums, left++, right);
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shiftZerosToTheEnd(new int[]{ 0, 1, 0, 3, 2})));
        System.out.println(Arrays.toString(shiftZerosToTheEndOptimised(new int[]{ 0, 1, 0, 3, 2 })));
    }
}
