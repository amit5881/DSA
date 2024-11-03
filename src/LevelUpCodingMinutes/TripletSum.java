package LevelUpCodingMinutes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

    // O(N^3)
    public static void tripletSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int currentSum = arr[i] + arr[j] + arr[k];
                    if (sum == currentSum) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }

    // O(NlogN) + O(N^2) = O(N^2)
    public static ArrayList<List<Integer>> tripletSum1(int[] arr, int targetSum) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int currentSum = arr[i] + arr[j] + arr[k];
                if (currentSum == targetSum) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    result.add(temp);
                    k--;
                    j++;
                } else if (currentSum > targetSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        tripletSum(new int[]{1,2,3,4,5,6,7,8,9,15}, 18);
        System.out.println(tripletSum1(new int[]{1,2,3,4,5,6,7,8,9,15}, 18));
    }
}
