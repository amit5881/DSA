package LeetCodeDaily;

import java.util.Arrays;
import java.util.List;

public class Triangle120 {

    public static int triangle(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(0, 0, triangle, dp);
    }

    private static int helper(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);

        if (dp[i][j] != null) return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(i + 1, j, triangle, dp), helper(i + 1, j + 1, triangle, dp));
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                List.of(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(triangle(triangle));
    }
}
