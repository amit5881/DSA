package CompanyWise.Apollo.io;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int countSubArraySumEqualsKBruteForce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int countSubArraySumEqualsKBetter(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int countSubArraySumEqualsKOptimised(int[] arr, int k) {
        int preSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static int[] firstSubarraySumEqualsK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum 0 occurs before index 0

        int preSum = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            int need = preSum - k;

            if (map.containsKey(need)) {
                int start = map.get(need) + 1;
                int end = i;
                return new int[]{start, end};
            }

            // store prefix sum only if first occurrence → ensures leftmost result
            map.putIfAbsent(preSum, i);
        }

        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        System.out.println(countSubArraySumEqualsKOptimised(new int[]{1, 1, 1}, 2));
        System.out.println(countSubArraySumEqualsKOptimised(new int[]{1, 2, 3}, 3));
    }
}
