package ByteByteGo.Graph;

import java.util.Arrays;

public class LongestIncreasingPath {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) return 0;
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }
        }
        return result;
    }

    private static int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c];

        int maxPath = 1;
        int[][] dirs = new int[][] {
                new int[]{-1, 0},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{0, 1}
        };

        for (int[] d : dirs) {
            int nextRow = r + d[0];
            int nextCol = c + d[1];

            if (isWithinBounds(matrix, nextRow, nextCol) && matrix[nextRow][nextCol] > matrix[r][c]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, nextRow, nextCol, memo));
            }
        }
        memo[r][c] = maxPath;

        return maxPath;
    }

    private static boolean isWithinBounds(int[][] matrix, int r, int c) {
        return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,5,8},
                new int[]{3,4,4},
                new int[]{7,9,2}
        };

        System.out.println(longestIncreasingPath(matrix));
    }
}
