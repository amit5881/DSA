package LeetCodeDaily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity_1488 {

    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        Map<Integer, Integer> rainyLakeDayMap = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                ans[i] = -1;
                if (rainyLakeDayMap.containsKey(lake)) {
                    int lastOccurrenceDay = rainyLakeDayMap.get(lake);
                    Integer prevDryDay = dryDays.ceiling(lastOccurrenceDay);
                    if (prevDryDay == null) return new int[0];
                    ans[prevDryDay] = lake;
                    dryDays.remove(prevDryDay);
                }
                rainyLakeDayMap.put(lake, i);
            } else {
                dryDays.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[] { 1, 2, 0, 0, 2, 1 })));
        System.out.println(Arrays.toString(avoidFlood(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(avoidFlood(new int[] { 1, 2, 0, 1, 2 })));
    }
}
