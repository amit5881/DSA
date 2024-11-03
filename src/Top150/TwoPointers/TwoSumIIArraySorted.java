package Top150.TwoPointers;

import java.util.Arrays;

public class TwoSumIIArraySorted {

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (numbers[start] + numbers[end] != target) {
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{ start + 1, end + 1 };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0},-1)));
    }
}
