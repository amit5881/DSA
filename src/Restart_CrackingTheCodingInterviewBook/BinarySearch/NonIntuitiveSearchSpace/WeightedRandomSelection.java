package Restart_CrackingTheCodingInterviewBook.BinarySearch.NonIntuitiveSearchSpace;

import java.util.Random;

public class WeightedRandomSelection {

    private final int[] prefixSum;
    private final Random random = new Random();

    public WeightedRandomSelection(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int solution() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) left = mid + 1;
            else right =mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = new int[] {3, 1, 2, 4};
        WeightedRandomSelection w = new WeightedRandomSelection(weights);
        System.out.println(w.solution());
        System.out.println(w.solution());
        System.out.println(w.solution());
    }
}
