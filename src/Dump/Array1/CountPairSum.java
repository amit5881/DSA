package Dump.Array1;

import java.util.HashSet;

public class CountPairSum {

    public static int pairSum(int[] arr, int sum) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int j : arr) {
            int required = sum - j;

            if (set.contains(required)) {
                count++;
            } else {
                set.add(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(pairSum(new int[]{0,6,0,0}, 6));
    }
}
