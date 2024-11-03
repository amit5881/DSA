package CodingMinutes.Sorting;

import java.util.Arrays;

import static CodingMinutes.Sorting.BubbleSort.swapElements;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min_pos = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[min_pos]) {
                    min_pos = j;
                }
            }
            swapElements(arr, i, min_pos);
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[] {5, 4, 3, 2, 1})));
    }
}
