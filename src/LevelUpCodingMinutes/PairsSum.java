package LevelUpCodingMinutes;

import java.util.Arrays;
import java.util.HashSet;

public class PairsSum {

    // O(n^2) approach
    public static int[] pairSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{ arr[i], arr[j] };
                }
            }
        }
        return new int[]{};
    }

    // O(nlogn) approach
    public static int[] pairSum2(int[] arr, int sum) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int currentSum = arr[start] + arr[end];
            if (currentSum == sum) {
                result[0] = arr[start];
                result[1] = arr[end];
                return result;
            } else if (sum < currentSum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    // O(n) approach
    public static int[] pairSum3(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            int diff = sum - i;
            if (set.contains(diff)) {
                return new int[]{diff, i};
            }
            set.add(i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSum3(new int[]{10, 5, 2, 3, -6, 9, 11}, 11)));
    }
}
