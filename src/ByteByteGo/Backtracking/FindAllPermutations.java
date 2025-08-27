package ByteByteGo.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllPermutations {

    private static List<List<Integer>> findAllPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> candidate, HashSet<Integer> used, List<List<Integer>> result) {
        if (candidate.size() == nums.length) {
            result.add(new ArrayList<>(candidate));
            return;
        }

        for (int num : nums) {
            if (!used.contains(num)) {
                candidate.add(num);
                used.add(num);
                backtrack(nums, candidate, used, result);
                candidate.remove(Integer.valueOf(num));
                used.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findAllPermutations(new int[] {4, 5, 6});
        System.out.println(Arrays.deepToString(result.toArray()));
    }
}