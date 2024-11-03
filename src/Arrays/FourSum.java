package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                for (int k = j + 1; k < arr.length - 1; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        int sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            int[] tempArr = new int[] {arr[i], arr[j], arr[k], arr[l]};
                            Arrays.sort(tempArr);
                            List<Integer> t = Arrays.asList(tempArr[0], tempArr[1], tempArr[2], tempArr[3]);
                            if (!result.contains(t)) result.add(t);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumOptimised(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                for (int k = j + 1; k < arr.length - 1; k++) {
                    int threeSum = arr[i] + arr[j] + arr[k];
                    int requiredSum = target - threeSum;

                    int start = k + 1;
                    int end = arr.length - 1;
                    List<Integer> tempList = Arrays.asList(arr[i], arr[j], arr[k], binarySearchTemp(arr, start, end, requiredSum));
                    if (!result.contains(tempList)) result.add(tempList);
                }
            }
        }
        return result;
    }

    public static int binarySearchTemp(int[] arr, int start, int end, int requiredSum) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == requiredSum) {
                return arr[mid];
            } else if (arr[mid] > requiredSum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = fourSumOptimised(new int[]{1,0,-1,0,-2,2}, 0);
//        List<List<Integer>> result = fourSumOptimised(new int[]{2,2,2,2,2}, 8);
//        List<List<Integer>> result = fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
//                2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
//                ,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
//                2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
//                2,2,2,2,2,2,2,2,2,2,2,2,2}, 8);
        System.out.println(result);
    }
}
