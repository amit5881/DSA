package Restart_CrackingTheCodingInterviewBook.HashMapAndSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroStriping {

    public static int[][] zeroStripingUsingHashSet(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows.add(r);
                    zeroCols.add(c);
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (zeroRows.contains(r) || zeroCols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] zeroStripingInSpace(int[][] matrix) {
        boolean firstRowHasZero = false;
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        boolean firstColHasZero = false;
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColHasZero) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5}, {6,0,8,9,10}, {11,12,13,14,15}, {16,17,18,19,0}};
        System.out.println(Arrays.deepToString(zeroStripingUsingHashSet(matrix)));

        matrix = new int[][]{{1,2,3,0,5}, {6,0,8,9,10},{ 11,12,13,14,15}, {16,17,18,19,0}};
        System.out.println(Arrays.deepToString(zeroStripingInSpace(matrix)));
    }
}
