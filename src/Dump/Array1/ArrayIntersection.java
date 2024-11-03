package Dump.Array1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayIntersection {

    public static int[] intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;

        int i = 0;
        int j = 0;

        ArrayList<Integer> list = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    private static void intersectionOptimised(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr1) {
            set.add(j);
        }
        for (int j : arr2) {
            if (set.contains(j)) {
                System.out.print(j + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 6, 8, 5, 4, 3};
        int[] arr2 = new int[]{2, 3, 4, 7};
        int[] result = intersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }


}
