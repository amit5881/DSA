package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Input: names = ["Mary","John","Emma"], heights = [180,165,170]
//Output: ["Mary","Emma","John"]
public class SortPeople {

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            hashMap.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] result = new String[heights.length];

        int idx = names.length - 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = hashMap.get(heights[idx--]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180,165,170})));
    }
}
