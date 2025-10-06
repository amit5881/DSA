package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static List<List<Integer>> pacificAtlanticWaterFlow(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];

        // left and right most
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }

        // top and bottom most
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i, heights[0][i]);
            dfs(heights, atlantic, m - 1, i, heights[m - 1][i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || heights[i][j] < prevHeight) return;

        visited[i][j] = true;
        for (int[] dir : dirs) dfs(heights, visited, i + dir[0], j + dir[1], heights[i][j]);
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        System.out.println(pacificAtlanticWaterFlow(heights));
    }
}
