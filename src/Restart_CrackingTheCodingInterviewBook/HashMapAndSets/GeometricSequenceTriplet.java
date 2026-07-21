package Restart_CrackingTheCodingInterviewBook.HashMapAndSets;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplet {

    public static int geometricSequenceTriplet(int[] nums, int ratio) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * ratio == nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] * ratio == nums[k]) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }

    public static int geometricSequenceTripletOptimised(int[] nums, int ratio) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int count = 0;

        for (int num : nums) rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);
            if (num % ratio == 0) {
                count += leftMap.getOrDefault(num / ratio, 0) * rightMap.getOrDefault(num * ratio, 0);
            }
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(geometricSequenceTriplet(new int[]{2, 1, 2, 4, 8, 8}, 2));
        System.out.println(geometricSequenceTripletOptimised(new int[]{2, 1, 2, 4, 8, 8}, 2));
    }
}
