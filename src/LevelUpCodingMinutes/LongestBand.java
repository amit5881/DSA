package LevelUpCodingMinutes;

import java.util.Arrays;
import java.util.HashSet;

public class LongestBand {

    // O(NlogN) + O(N)
    public static int longestBand(int[] arr) {
        Arrays.sort(arr);

        int index = 1;
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                index++;
                maxLength = Math.max(index, maxLength);
            } else {
                index = 1;
            }
        }
        return maxLength;
    }

    // O(N)
    public static int longestBand1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }

        int maxLength = 0;
        for (int j : arr) {
            int element = j;
            int currentLength = 0;

            while (set.contains(element)) {
                currentLength++;
                element = element - 1;
            }
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestBand1(new int[]{1,9,3,0,18,5,2,4,10,7,12,6}));
    }
}
