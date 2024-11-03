package CodingMinutes.Arrays;

import java.util.Arrays;

public class KRotate {

    public static int[] simpleSolution(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int index= 0;
        int[] answer = new int[n];
        for (int i = n - k; i < n; i++) answer[index++] = arr[i];
        for (int i = 0; i < n - k; i++) answer[index++] = arr[i];
        return answer;
    }

    /*
    [1,2,3,4,5,6,7]
    [5,4,3,2,1,7,6]
    [6,7,1,2,3,4,5]
     */
    public static int[] inPlaceSolution(int[] arr, int k) {
        k = k % arr.length;

        int n = arr.length - 1;
        reverseArray(arr, 0, n - k);
        reverseArray(arr, arr.length - k, n);
        reverseArray(arr, 0, n);
        return arr;
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(inPlaceSolution(new int[]{1,2,3,4,5,6,7,8}, 2)));
    }
}
