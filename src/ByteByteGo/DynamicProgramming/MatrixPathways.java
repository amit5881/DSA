package ByteByteGo.DynamicProgramming;

import java.util.Arrays;

public class MatrixPathways {

    private static int matrixPathways(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) dp[i][0] = 1;

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int matrixPathwaysOptimised(int m, int n) {
        int[] prevRow = new int[n];
        Arrays.fill(prevRow, 1);

        for (int r = 1; r < m; r++) {
            int[] currRow = new int[n];
            Arrays.fill(currRow, 1);

            for (int c = 1; c < n; c++) {
                currRow[c] = prevRow[c] + currRow[c - 1];
            }
            prevRow = currRow;
        }
        return prevRow[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(matrixPathways(3, 3));
        System.out.println(matrixPathways(4, 4));

        System.out.println(matrixPathwaysOptimised(3, 3));
        System.out.println(matrixPathwaysOptimised(4, 4));
    }
}