package ByteByteGo.PrefixSums;

import java.util.Arrays;

public class ProductArrayWithoutCurrentElement {

    public static int[] bruteForce(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public static int[] bruteForce2(int[] arr) {
        int product = Arrays.stream(arr).reduce(1, (a, b) -> a * b);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = product / arr[i];
        }
        return arr;
    }

    public static int[] productArrayWithoutCurrentElement(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int rightProduct = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bruteForce(new int[]{2,3,1,4,5})));
        System.out.println(Arrays.toString(bruteForce2(new int[]{2,3,1,4,5})));
        System.out.println(Arrays.toString(productArrayWithoutCurrentElement(new int[]{2,3,1,4,5})));
    }
}
