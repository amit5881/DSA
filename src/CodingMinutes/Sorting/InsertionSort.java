package CodingMinutes.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 4, 3, 2, 1})));
    }
}
