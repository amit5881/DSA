package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumCloses(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int currentSum = arr[i] + arr[start] + arr[end];
                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }

                if (currentSum > target) {
                    end--;
                } else if (currentSum < target) {
                    start++;
                } else {
                    return currentSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumCloses(new int[]{-1,2,1,-4}, 1));
    }
}
