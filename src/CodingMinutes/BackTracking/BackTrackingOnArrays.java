package CodingMinutes.BackTracking;

import java.util.Arrays;

public class BackTrackingOnArrays {

    public static void fillArray(int[] arr, int i, int val) {
        if (i == arr.length) return;

        arr[i] = val;
        fillArray(arr, i + 1, val + 1);
        arr[i] *= -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        fillArray(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }
}
