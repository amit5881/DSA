package CodingMinutes.RecursionBasics;

import java.util.Arrays;

public class FirstOccurence {

    public static int firstOccurence(int[] arr, int key, int i) {
        if (arr.length == 0) return -1;
        if (arr[0] == key) return 0;
        int subIndex = firstOccurence(Arrays.copyOfRange(arr, i + 1, arr.length), key, i);
        if (subIndex != -1) return subIndex + 1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurence(new int[]{1,2,3,4,5,6}, 6, 0));
    }
}
