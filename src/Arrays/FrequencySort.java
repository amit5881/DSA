package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {

    public static int[] frequencySort(int[] nums) {
        int[][] frequency = new int[201][2];

        for (int i = 0; i < 201; i++) {
            frequency[i][0] = i - 100;
        }

        for (int i : nums) {
            frequency[i + 100][1]++;
        }

        System.out.println(Arrays.deepToString(frequency));

        Arrays.sort(frequency, (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));

        int k = 0;
        for (int i = 0; i < frequency.length; i++) {
            for (int j = 0; j < frequency[i][1]; j++) {
                nums[k++] = frequency[i][0];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[] {1,1,2,2,2,3})));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
