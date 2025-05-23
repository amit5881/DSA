package CodingMinutes.Arrays;

import java.util.Arrays;

public class ArrayReverse {

    public static int[] arrayReverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayReverse(new int[]{1, 2, 3, 4, 5})));
    }
}
