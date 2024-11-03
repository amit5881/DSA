package CodingMinutes.RecursionBasics;

import java.util.Arrays;

public class LastOccurence {

    public static int lastOccurence(int[] arr, int key, int i) {
        if (arr.length == 0) return -1;
        int subIndex = lastOccurence(Arrays.copyOfRange(arr, i + 1, arr.length), key, i);
        if (subIndex == -1) {
            if (arr[0] == key)
                return 0;
            else
                return -1;
        } else {
            return subIndex + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(lastOccurence(new int[]{1,2,3,4,5,3}, 3, 0));
    }
}
