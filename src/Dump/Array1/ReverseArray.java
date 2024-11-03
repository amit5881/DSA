package Dump.Array1;

import java.util.Arrays;

public class ReverseArray {

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        reverse(new int[]{1, 2, 3, 4, 5});
    }
}
