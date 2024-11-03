package CodingMinutes.Sorting;


import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    swapElements(arr, j, j + 1);
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] optimisedBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    public static void main(String[] args) {
//       int[] result = optimisedBubbleSort(new int[] {5,4,3,2,1});
       int[] result = optimisedBubbleSort(new int[] {1,2,5,4,3});
       System.out.println(Arrays.toString(result));
    }
}
