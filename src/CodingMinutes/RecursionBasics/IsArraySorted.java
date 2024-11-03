package CodingMinutes.RecursionBasics;

import java.util.Arrays;

public class IsArraySorted {

    public static boolean isSorted(int[] arr, int i) {
        if (arr.length == 0 || arr.length == 1) return true;
        return arr[0] < arr[1] && isSorted(Arrays.copyOfRange(arr, i + 1, arr.length), i + 1);
    }

    public static boolean isArraySorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        return arr[i] < arr[i + 1] && isArraySorted(arr, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[] {1,2,3,4,1}, 0));
    }
}
