package ByteByteGo.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MatrixInfection {

    public static int matrixInfection(int[][] matrix) {
        int[][] directions = new int[][] {
                new int[] { -1, 0 },
                new int[] { 1, 0 },
                new int[] { 0, -1 },
                new int[] { 0, 1 }
        };
        int ones = 0;
        int seconds = 0;
        Queue<List<Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    ones++;
                } else if (matrix[i][j] == 2) {
                    queue.add(List.of(i, j));
                }
            }
        }

        while (!queue.isEmpty() && ones > 0) {
            seconds++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                List<Integer> cell = queue.poll();
                int row = cell.getFirst();
                int col = cell.getLast();

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (isWithinBounds(matrix, nextRow, nextCol) && matrix[nextRow][nextCol] == 1) {
                        matrix[nextRow][nextCol] = 2;
                        ones--;
                        queue.add(List.of(nextRow, nextCol));
                    }
                }
            }
        }
        return ones == 0 ? seconds : -1;
    }

    private static boolean isWithinBounds(int[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] {1, 1, 1, 0},
                new int[] {0, 0, 2, 1},
                new int[] {0, 1, 1, 0}
        };
        int seconds = matrixInfection(matrix);
        System.out.println(seconds);
    }
}
