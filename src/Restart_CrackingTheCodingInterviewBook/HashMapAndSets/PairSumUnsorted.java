package Restart_CrackingTheCodingInterviewBook.HashMapAndSets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSumUnsorted {

    public static int[] pairSumUnsortedTwoPass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[] { i, numMap.get(complement) };
            }
        }
        return new int[]{};
    }

    public static int[] pairSumUnSortedSinglePass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) return new int[]{ numMap.get(complement), i };
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSumUnsortedTwoPass(new int[]{-1, 3, 4, 2}, 3)));
        System.out.println(Arrays.toString(pairSumUnSortedSinglePass(new int[]{-1, 3, 4, 2}, 3)));
    }
}
