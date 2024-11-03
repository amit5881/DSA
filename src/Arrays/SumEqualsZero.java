package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumEqualsZero {

    public static int[] solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (map.containsKey(currentSum)) {
                int start = map.get(currentSum);
                result[0] = start + 1;
                result[1] = i;
            }
            map.put(currentSum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{-3, 2, 3, 1, 6})));
    }
}
