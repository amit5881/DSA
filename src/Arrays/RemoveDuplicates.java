package Arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int index = 1;
        for (int i = 1; i < arr.length; i++) if (arr[i] != arr[index - 1]) arr[index++] = arr[i];
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 2}));
    }
}
