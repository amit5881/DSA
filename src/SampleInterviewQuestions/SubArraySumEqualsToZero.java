package SampleInterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsToZero {

    private static int[] subArraySumEqualsToZero1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;

        int[] result = new int[]{-1, -1};
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum)) {
                int start = map.get(currentSum) + 1;
                result[0] = start;
                result[1] = i;
            }

            // Store the current cumulative sum in the map
            map.put(currentSum, i);
        }


        // No subarray with sum 0 found
        return result;
    }


    private static int[] subArraySum(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (map.containsKey(currentSum)) {
                int start = map.get(currentSum) + 1;
                result[0] = start;
                result[1] = i;
            }
            map.put(currentSum, i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] result = subArraySum(new int[] {0,-1,2,2,-4});
        System.out.println(Arrays.toString(result));
    }

  
}
