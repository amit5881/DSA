package ByteByteGo.PrefixSums;

import java.util.HashMap;
import java.util.Map;

public class KSumSubarrays {

    public static int countKSumSubarrays(int[] arr, int k) {
        int count = 0;
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int j = 1; j < prefixSum.length; j++) {
            for (int i = 1; i < j + 1; i++) {
                if (prefixSum[j] - prefixSum[i - 1] == k) count++;
            }
        }

        return count;
    }

    public static int countKSumSubArraysOptimised(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int currentPrefixSum = 0;

        for (int num : nums) {
            currentPrefixSum += num;

            int reqSum = currentPrefixSum - k;
            if (prefixSumMap.containsKey(reqSum)) count += prefixSumMap.get(reqSum);

            int freq = prefixSumMap.getOrDefault(currentPrefixSum, 0);
            prefixSumMap.put(currentPrefixSum, freq + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countKSumSubarrays(new int[] {1,2,-1,1,2}, 3));
        System.out.println(countKSumSubArraysOptimised(new int[] {1,2,-1,1,2}, 3));
    }
}
