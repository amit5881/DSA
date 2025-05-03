package HashMapAndSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

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
        return Arrays.asList(
                Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2),
                Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8),
                Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7),
                Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3),
                Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1),
                Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6),
                Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4),
                Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5),
                Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
    }

    public static List<List<Integer>> getInvalidInput() {
        return Arrays.asList(
                Arrays.asList(5, 3, 0, 0, 7, 0, 0, 5, 0), // Invalid: duplicate 5 in row
                Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0),
                Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0),
                Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3),
                Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1),
                Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6),
                Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0),
                Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5),
                Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9));
    }

}

