package LevelUpCodingMinutes;

import java.util.Arrays;

public class SubArraySort {

    public static int[] subArraySort(int[] arr) {
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);

        int start = 0;
        int end = arr.length - 1;

        while (start < arr.length && arr[start] == sortedArray[start]) {
            start++;
        }

        while (end > 0 && arr[end] == sortedArray[end]) {
            end--;
        }

        if (start == arr.length) {
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }

    public static int[] subArraySortOptimal(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (isOutOfOrder(arr, i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }
        if (smallest == Integer.MAX_VALUE) return new int[]{-1, -1};

        int left = 0;
        int right = arr.length - 1;

        while (smallest >= arr[left]) left++;
        while (largest <= arr[right]) right--;

        return new int[]{left, right};
    }

    private static boolean isOutOfOrder(int[] arr, int i) {
        if (i == 0) return arr[0] > arr[1];
        if (i == arr.length - 1) return arr[i] < arr[i - 1];
        return arr[i] < arr[i - 1] || arr[i] > arr[i + 1];
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,8,6,7,9,10,11};
        int[] arr = new int[]{1,2,3,4,13,9,10,11};
        System.out.println(Arrays.toString(subArraySortOptimal(arr)));
    }
}
