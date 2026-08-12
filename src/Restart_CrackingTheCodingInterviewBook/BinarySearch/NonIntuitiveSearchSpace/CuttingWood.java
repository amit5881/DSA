package Restart_CrackingTheCodingInterviewBook.BinarySearch.NonIntuitiveSearchSpace;

import java.util.Arrays;

public class CuttingWood {

    public static int cuttingWood(int[] heights, int target) {
        if (heights.length == 0) return 0;
        int left = 0, right = Arrays.stream(heights).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (cutEnoughWood(mid, target, heights)) left = mid;
            else right = mid - 1;
        }
        return right;
    }

    private static boolean cutEnoughWood(int mid, int target, int[] heights) {
        int woodCollected = 0;
        for (int height : heights) {
            if (height > mid) woodCollected += height - mid;
        }
        return woodCollected >= target;
    }

    public static void main(String[] args) {
        System.out.println(cuttingWood(new int[]{2, 6, 3, 8}, 7));
    }
}
