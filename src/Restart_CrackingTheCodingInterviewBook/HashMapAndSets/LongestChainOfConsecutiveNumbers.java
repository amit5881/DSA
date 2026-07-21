package Restart_CrackingTheCodingInterviewBook.HashMapAndSets;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestChainOfConsecutiveNumbers {

    public static int longestChainOfConsecutiveNumbersBruteForce(int[] nums) {
        if (nums.length == 0) return 0;

        int longestChain = 0;

        for (int num : nums) {
            int currentNumber = num;
            int currentChain = 1;

            while (contains(nums, currentNumber + 1)) {
                currentNumber++;
                currentChain++;
            }
            longestChain = Math.max(longestChain, currentChain);
        }
        return longestChain;
    }

    private static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    public static int longestChainOfConsecutiveNumbersSorting(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int longest = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == (nums[i - 1] + 1)) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        return Math.max(longest, current);
    }

    public static int longestChainOfConsecutiveNumbersOptimised(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestChain = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentChain = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentChain++;
                }
                longestChain = Math.max(longestChain, currentChain);
            }
        }
        return longestChain;
    }

    public static void main(String[] args) {
        System.out.println(longestChainOfConsecutiveNumbersBruteForce(new int[]{1, 6, 2, 5, 8, 7, 10, 3}));
        System.out.println(longestChainOfConsecutiveNumbersSorting(new int[]{1, 6, 2, 5, 8, 7, 10, 3}));
        System.out.println(longestChainOfConsecutiveNumbersOptimised(new int[]{1, 6, 2, 5, 8, 7, 10, 3}));
    }
}
