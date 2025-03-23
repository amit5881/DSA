package TwoPointers;

import java.util.*;
import java.util.stream.Stream;

public class TripletSum {

    public static List<List<Integer>> tripletSumBruteForce(int[] arr) {
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        resultSet.add(Stream.of(arr[i], arr[j], arr[k]).sorted().toList());
                    }
                }
            }
        }
        return resultSet.stream().toList();
    }

    public static List<List<Integer>> tripletSumEqualsZeroOptimised(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) break;
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            List<List<Integer>> pairList = pairSumAll(arr, i + 1, - arr[i]);
            for (List<Integer> pair : pairList) triplets.add(List.of(arr[i], pair.get(0), pair.get(1)));
        }
        return triplets;
    }

    private static List<List<Integer>> pairSumAll(int[] arr, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                pairs.add(List.of(arr[left], arr[right]));
                do left++;
                while (left < right && arr[left] == arr[left - 1]);
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(tripletSumBruteForce(new int[]{0,-1,2,-3,1}));
        System.out.println(tripletSumBruteForce(new int[]{-4,-4,-2,0,1,2,3}));

        System.out.println("===OPTIMISED===");
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{0,-1,2,-3,1}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{-4,-4,-2,0,1,2,3}));

        System.out.println("===TESTS===");
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{0}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{1, -1}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{0,0,0}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{1,0,1}));
        System.out.println(tripletSumEqualsZeroOptimised(new int[]{0,0,1,-1,1,-1}));
    }
}
