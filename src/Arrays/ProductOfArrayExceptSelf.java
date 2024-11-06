package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productArrayExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        int left = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] *= left;
            left *= arr[i];
        }

        int right = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productArrayExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productArrayExceptSelf(new int[] {-1,1,0,-3,3})));
    }
}
