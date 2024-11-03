package CodingMinutes.Arrays;

import java.util.Arrays;

public class SortedPairSum {

    public static int[] closestSum(int[] arr, int sum) {
        int start = 0;
        int end = arr.length - 1;
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (start < end) {

            int currentSum = arr[start] + arr[end];

            if (Math.abs(currentSum - sum) < diff) {
                left = start;
                right = end;
                diff = Math.abs(currentSum - sum);
            }
            if (currentSum > sum) {
                end--;
            } else {
                start++;
            }

        }
        return new int[]{arr[left], arr[right]};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestSum(new int[] {10, 22, 28, 29, 30, 40}, 54)));
    }
}
