package Top150.Arrays;

import java.util.Arrays;

public class RotateArray {

    /*
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
     */
    public static void rotate1(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }

        System.out.println(Arrays.toString(rotated));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rotated[i];
        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        start = 0;
        end = k - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        start = k;
        end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
