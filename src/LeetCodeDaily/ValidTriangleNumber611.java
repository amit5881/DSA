package LeetCodeDaily;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ValidTriangleNumber611 {

    public static int validTriangleNumber(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int validTriangleNumberOptimized(int[] arr) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    count += right - left;
                    right--;
                } else left++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(validTriangleNumberOptimized(new int[]{2,2,3,4}));
        System.out.println(validTriangleNumberOptimized(new int[]{4,2,3,4}));
        System.out.println(validTriangleNumberOptimized(new int[]{7,0,0,0}));
    }
}
