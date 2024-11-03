package Dump;

import java.util.*;

public class TwoSum {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
//        int[] arr = new int[]{2,7,11,15};

//        optimalList(arr, 3);
        optimalListMap(arr, 3);
    }

    private static void optimalListMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = target - arr[i];
            if (map.containsKey(element)) {
                System.out.println(i + " :: " + map.get(element));
            }
            map.put(arr[i], i);
        }
    }

    private static void bruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + "::" + arr[j]);
                }
            }
        }
    }

    private static void optimalList(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int element = target - arr[i];
            if (set.contains(element)) {
                System.out.println(arr[i] + " :: " + element);
            }
            set.add(arr[i]);
        }
    }


}
