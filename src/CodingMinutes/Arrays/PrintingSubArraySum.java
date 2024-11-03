package CodingMinutes.Arrays;

public class PrintingSubArraySum {

    // BruteForce O(N^3)
    public static int printingSubArraySum1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currMax = 0;
                for (int k = i; k < j; k++) {
                    currMax += arr[k];
                }
                maxSum = Math.max(currMax, maxSum);
            }
        }
        return maxSum;
    }

    // Prefix Sum
    public static int printingSubArraySum2(int[] arr) {
        int[] prefix = new int[100];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subArraySum = i > 0 ? prefix[j] - prefix[i - 1] : prefix[j];
                maxSum = Math.max(maxSum, subArraySum);
            }
        }
        return maxSum;
    }

    // kadane Algorithm
    public static int maximumSubArraySum(int[] arr) {
        int currentSum = 0;
        int maximumSum = 0;

        for (int i : arr) {
            currentSum += i;
            if (currentSum < 0) currentSum = 0;

            maximumSum = Math.max(currentSum, maximumSum);
        }
        return maximumSum;
    }

    // kadane Algorithm with special case with all -ve values in an array
    public static int maxSubArraySum(int[] arr) {
        boolean isAllNegative = true;
        int largest = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > 0) {
                isAllNegative = false;
            }
            largest = Math.max(largest, j);
        }
        // special case if all elements are -ve
        if (isAllNegative) {
            return largest;
        }

        // kadane's logic
        int currentSum = 0;
        int maxSum = 0;
        for (int j : arr) {
            currentSum += j;
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubArraySum(new int[] {1, 3, 4, 0, -1, -1, -2}));
    }
}
