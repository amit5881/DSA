package Arrays;

import java.util.Arrays;

public class PivotIndex {


    public static int pivotIndex(int[] arr) {
        if (arr.length == 1) return -1;
        int rightSum = Arrays.stream(arr).sum();
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
    }
}
