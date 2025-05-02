package HashMapAndSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static boolean verifySudokuBoard(List<List<Integer>> board) {
        List<Set<Integer>> rowSets = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            rowSets.add(new HashSet<>());
        }

        List<Set<Integer>> columnSets = new ArrayList<>();
        for (int i = 0; i < board.getFirst().size(); i++) {
            columnSets.add(new HashSet<>());
        }

        List<List<Set<Integer>>> subGridSets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Set<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(new HashSet<>());
            }
            subGridSets.add(temp);
        }

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                Integer num = board.get(i).get(j);

                if (num == 0) continue;

                if (rowSets.get(i).contains(num)) return false;
                if (columnSets.get(j).contains(num)) return false;
                if (subGridSets.get(i / 3).get(j / 3).contains(num)) return false;

                rowSets.get(i).add(num);
                columnSets.get(j).add(num);
                subGridSets.get(i / 3).get(j / 3).add(num);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifySudokuBoard(getValidInput()));
        System.out.println(verifySudokuBoard(getInvalidInput()));
    }

    public static List<List<Integer>> getValidInput() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        List<List<Integer>> boardList = new ArrayList<>();

        for (char[] chars : board) {
            List<Integer> row = new ArrayList<>();
            for (char aChar : chars) {
                if (aChar == '.') {
                    row.add(0); // Empty cell
                } else {
                    row.add(aChar - '0'); // Convert char digit to int
                }
            }
            boardList.add(row);
        }
        return boardList;
    }

    public static List<List<Integer>> getInvalidInput() {
        char[][] invalidBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '5', '.'}, // <-- Duplicate '5' in row
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        List<List<Integer>> boardList = new ArrayList<>();

        for (char[] chars : invalidBoard) {
            List<Integer> row = new ArrayList<>();
            for (char aChar : chars) {
                if (aChar == '.') {
                    row.add(0); // Empty cell
                } else {
                    row.add(aChar - '0'); // Convert char digit to int
                }
            }
            boardList.add(row);
        }
        return boardList;
    }

}

