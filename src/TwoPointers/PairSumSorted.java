package TwoPointers;

import java.util.Arrays;

public class PairSumSorted {

    public static int[] pairSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] pairSumTwoPointer(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{ left, right };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{}, 0)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{1}, 1)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{2, 3}, 5)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{2, 4}, 5)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{2, 2, 3}, 5)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{-1, 2, 3}, 2)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(pairSumTwoPointer(new int[]{-3, -2, -1}, -5)).toArray()));
    }
}
