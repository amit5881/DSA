package Restart_CrackingTheCodingInterviewBook.BinarySearch.NonIntuitiveSearchSpace;

import java.util.Arrays;

public class KokoEatingBanana {

    public static int kokoEatingBanana(int[] piles, int hours) {
        if (piles.length == 0) return 0;
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalHours = canFinishIn(piles, mid);
            if (totalHours <= hours) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long canFinishIn(int[] piles, int hours) {
        long totalHours = 0;
        for (int pile : piles) totalHours += (long) Math.ceil((double) pile / hours);
        return totalHours;
    }

    public static void main(String[] args) {
//        System.out.println(kokoEatingBanana(new int[]{3,6,7,11}, 8));
//        System.out.println(kokoEatingBanana(new int[]{30,11,23,4,20}, 5));
//        System.out.println(kokoEatingBanana(new int[]{30,11,23,4,20}, 6));
        System.out.println(kokoEatingBanana(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}
