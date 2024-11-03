package CodingMinutes.RecursionBasics;

import java.util.Arrays;

public class BubbleSortRecursive {

    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 0) return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1};
        bubbleSortRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
