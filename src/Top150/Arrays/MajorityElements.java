package Top150.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {

    public static int majorityElements(int[] arr) {
        for (int k : arr) {
            int count = 0;

            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count > arr.length / 2) return k;
        }
        return -1;
    }

    // hash map
    public static int betterSolution(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : arr) {
            if (hashMap.containsKey(j)) {
                int count = hashMap.get(j);
                hashMap.put(j, count + 1);
            } else {
                hashMap.put(j, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(betterSolution(new int[]{3,2,3}));
    }
}
