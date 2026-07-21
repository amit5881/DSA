package Restart_CrackingTheCodingInterviewBook.HashMapAndSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudokuBoard {

    public static boolean validSudokuBoard(int[][] board) {
        List<Set<Integer>> rowSets = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            rowSets.add(new HashSet<>());
        }

        List<Set<Integer>> colSets = new ArrayList<>();
        for (int i = 0; i < board[0].length; i++) {
            colSets.add(new HashSet<>());
        }

        List<List<Set<Integer>>> gridSets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Set<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(new HashSet<>());
            }
            gridSets.add(temp);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int num = board[r][c];
                if (num == 0) continue;
                if (rowSets.get(r).contains(num)) return false;
                if (colSets.get(c).contains(num)) return false;
                if (gridSets.get(r / 3).get(c / 3).contains(num)) return false;

                rowSets.get(r).add(num);
                colSets.get(c).add(num);
                gridSets.get(r / 3).get(c / 3).add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validSudokuBoard(new int[][]{
                {3,0,6,5,8,4,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {1,0,2,5,0,0,3,2,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {0,3,0,0,0,8,2,5,0},
                {0,1,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,0,0,0}
        }));

        System.out.println(validSudokuBoard(new int[][]{
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        }));
    }
}
