package LevelUpCodingMinutes.SlidingWindow;

import java.util.Arrays;

public class Housing {

    public static void housing(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == target) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    public static void housingUsingPrefixSum(int[] arr, int target) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (prefixSum[j] - prefixSum[i] == target) {
                    System.out.println(i + 1 + " " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        housing(new int[] { 1,3,2,1,4,1,3,2,1,1,2 }, 8);
        housing(new int[] { 1,3,2,5 }, 7);
        System.out.println();
        housingUsingPrefixSum(new int[] { 1,3,2,1,4,1,3,2,1,1,2 }, 8);
        System.out.println();
    }
}
