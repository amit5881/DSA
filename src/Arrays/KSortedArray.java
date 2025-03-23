package Arrays;

import java.util.Arrays;

public class KSortedArray {

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > currentElement) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = currentElement;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{6, 5, 3, 2, 8, 10, 9})));
    }
}
