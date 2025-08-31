package ByteByteGo.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueens {

    public static int result = 0;

    public static int nQueens(int n) {
        dfs(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
        return result;
    }

    private static void dfs(int row, Set<Integer> diagonalSet, Set<Integer> antiDiagonalSet, Set<Integer> colSet, int n) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;

            if (colSet.contains(col) ||
                    diagonalSet.contains(currentDiagonal) ||
                    antiDiagonalSet.contains(currentAntiDiagonal)) {
                continue;
            }

            colSet.add(col);
            diagonalSet.add(currentDiagonal);
            antiDiagonalSet.add(currentAntiDiagonal);

            dfs(row + 1, diagonalSet, antiDiagonalSet, colSet, n);

            // backtrack
            colSet.remove(col);
            diagonalSet.remove(currentDiagonal);
            antiDiagonalSet.remove(currentAntiDiagonal);
        }
    }

    public static void main(String[] args) {
        System.out.println(nQueens(4));
    }
}
