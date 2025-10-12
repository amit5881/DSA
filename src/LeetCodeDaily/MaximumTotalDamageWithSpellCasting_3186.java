package LeetCodeDaily;

import java.util.*;

public class MaximumTotalDamageWithSpellCasting_3186 {

    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int p : power) {
            freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);
        }

        List<Integer> uniq = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniq);

        Long[] dp = new Long[uniq.size()]; // adding DP
        return helper(uniq, freqMap, uniq.size() - 1, dp);
    }

    private static long helper(List<Integer> arr, Map<Integer, Integer> freqMap, int i, Long[] dp) {
        if (i < 0) return 0;

        if (dp[i] != null) return dp[i];

        long skip = helper(arr, freqMap, i - 1, dp);

        int curr = arr.get(i);
        long take = (long) curr * freqMap.get(curr);

        int j = binarySearch(arr, i - 1, curr - 2);

        take += helper(arr, freqMap, j, dp);
        return dp[i] = Math.max(skip, take);
    }

    private static int binarySearch(List<Integer> arr, int right, int val) {
        int left = 0, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < val) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[]{7, 1, 6, 6}));
    }
}
