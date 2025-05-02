package HashMapAndSets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static int[] pairSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{ i, j };
                }
            }
        }
        return new int[]{};
    }

    public static int[] pairSumTwoPass(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }

    public static int[] pairSumOnePass(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSumTwoPass(new int[]{-1, 3, 4, 2}, 3)));
        System.out.println(Arrays.toString(pairSumOnePass(new int[]{-1, 3, 4, 2}, 3)));
        System.out.println(Arrays.toString(pairSum(new int[]{-1, 3, 4, 2}, 3)));
    }
}
