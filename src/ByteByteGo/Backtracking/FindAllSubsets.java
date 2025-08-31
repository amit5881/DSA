package ByteByteGo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);
        return result;
    }

    private static void backtrack(int i, List<Integer> currentSubset, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.addLast(nums[i]);
        backtrack(i + 1, currentSubset, nums, result);

        currentSubset.removeLast();
        backtrack(i + 1, currentSubset, nums, result);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findAllSubsets(new int[] {4, 5, 6});
        System.out.println(result);
    }
}
