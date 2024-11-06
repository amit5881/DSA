package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsToK {

    public static int subArraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == k) count++;
            }
        }

        return count;
    }

    public static int subArraySumOptimal(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, 1);
        }
        System.out.println(map);
        return count;
    }


    public static void main(String[] args) {
        System.out.println(subArraySumBruteForce(new int[]{1,1,1}, 2));
        System.out.println(subArraySumBruteForce(new int[]{1,2,3}, 3));

        System.out.println();

        System.out.println(subArraySumOptimal(new int[]{1,1,1}, 2));
        System.out.println(subArraySumOptimal(new int[]{1,2,3}, 3));
    }
}
