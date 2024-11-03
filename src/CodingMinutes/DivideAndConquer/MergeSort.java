package CodingMinutes.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeSortedArrays(arr, start, end);
    }

    private static void mergeSortedArrays(int[] arr, int start, int end) {
        int i = start;
        int mid = (start + end) / 2;
        int j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j])
                temp.add(arr[i++]);
            else
                temp.add(arr[j++]);
        }
        while (i <= mid)
            temp.add(arr[i++]);
        while (j <= end)
            temp.add(arr[j++]);
        int k = 0;
        for (int l = start; l <= end; l++)
            arr[l] = temp.get(k++);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
