package LeetCodeDaily;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {

    public static int[] successfulPairs(int[] spells, int[] potions, int success) {
        int[] result = new int[spells.length];
        int idx = 0;
        for (int spell : spells) {
            int current = 0;
            for (int potion : potions) {
                if ((long) spell * potion >= success) {
                    current++;
                }
            }
            result[idx++] = current;
        }
        return result;
    }

    public static int[] successfulPairsOptimised(int[] spells, int[] potions, int success) {
        int n = spells.length, m = potions.length;
        int[] result = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int index = getMinPotion(spells[i], potions, success);
            result[i] = m - index;
        }
        return result;
    }

    private static int getMinPotion(int spell, int[] potions, int success) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) potions[mid] * spell >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println(Arrays.toString(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));


        System.out.println(Arrays.toString(successfulPairsOptimised(new int[]{5, 1, 3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println(Arrays.toString(successfulPairsOptimised(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }
}
