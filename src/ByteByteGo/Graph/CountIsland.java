package ByteByteGo.Graph;

public class CountIsland {


    private static int countIsland(int[][] matrix) {
        if (matrix == null) return 0;

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] matrix, int row, int column) {
        matrix[row][column] = -1;

        int[][] directions = new int[][] {
                new int[]{-1, 0},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{0, 1}
        };

        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextColumn = column + dir[1];

            if (isWithinBounds(matrix, nextRow, nextColumn) && matrix[nextRow][nextColumn] == 1) {
                dfs(matrix, nextRow, nextColumn);
            }
        }
    }

    private static boolean isWithinBounds(int[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] {1, 1, 0, 0},
                new int[] {1, 1, 0, 0},
                new int[] {0, 0, 1, 1},
                new int[] {0, 0, 0, 1}
        };

        int result = countIsland(matrix);
        System.out.println(result);
    }

}
