package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraysDivisibleByK {

    public static int subArraySum(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum % k == 0) count++;
            }
        }
        return count;
    }

    public static int subArraySumDivisbleByK(int[] arr, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int rem = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) {
                result += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subArraySum(new int[] {4,5,0,-2,-3,1}, 5));
        System.out.println(subArraySum(new int[] {5}, 9));
        System.out.println();
        System.out.println(subArraySumDivisbleByK(new int[] {4,5,0,-2,-3,1}, 5));
        System.out.println(subArraySumDivisbleByK(new int[] {5}, 9));
    }
}
