package Restart_CrackingTheCodingInterviewBook.TwoPointers;

import java.util.*;
import java.util.stream.Stream;

public class TripletSum {

    public static List<List<Integer>> bruteForce(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Stream.of(nums[i], nums[j], nums[k]).sorted().toList();
                        triplets.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    public static List<List<Integer>> optimised(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> pairs = findPairsFromSortedArr(nums, i + 1, -nums[i]);
            for (List<Integer> pair : pairs) triplets.add(new ArrayList<>(List.of(nums[i], pair.get(0), pair.get(1))));
        }
        return triplets;
    }

    private static List<List<Integer>> findPairsFromSortedArr(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                pairs.add(new ArrayList<>(List.of(nums[left], nums[right])));
                left++;
                while (left < right && nums[left] == nums[left - 1]) left++;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(new int[] {0, -1, 2, -3, 1}));
        System.out.println(optimised(new int[] {0, -1, 2, -3, 1}));
    }
}
