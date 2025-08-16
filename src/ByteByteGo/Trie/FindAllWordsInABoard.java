package ByteByteGo.Trie;

import java.util.ArrayList;
import java.util.List;

public class FindAllWordsInABoard {

    public static class Trie {
        Trie[] children;
        String word;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    public static List<String> findAllWordsInABoard(List<List<String>> board, List<String> words) {
        Trie root = new Trie();
        // insert all the words to the trie
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.word = word;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                // if we found any char in board starts with any word in trie
                int index = board.get(i).get(j).toCharArray()[0] - 'a';
                if (root.children[index] != null) {
                    dfs(board, i, j, root.children[index], result);
                }
            }
        }
        return result;
    }

    private static void dfs(List<List<String>> board, int row, int column, Trie node, List<String> result) {
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicated
        }

        String temp = board.get(row).get(column);
        board.get(row).set(column, "*"); // mark visited

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = column + dir[1];

            if (isWithinBound(board, nextRow, nextCol) &&
                    board.get(nextRow).get(nextCol).charAt(0) != '*' &&
                    node.children[board.get(nextRow).get(nextCol).charAt(0) - 'a'] != null) {

                dfs(board, nextRow, nextCol, node.children[board.get(nextRow).get(nextCol).charAt(0) - 'a'], result);
            }
        }
        board.get(row).set(column, temp);
    }

    private static boolean isWithinBound(List<List<String>> board, int row, int column) {
        return 0 <= row && row < board.size() && 0 <= column && column < board.getFirst().size();
    }

    public static void main(String[] args) {
        List<List<String>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of("b", "y", "s")));
        board.add(new ArrayList<>(List.of("r", "t", "e")));
        board.add(new ArrayList<>(List.of("a", "i", "n")));

        List<String> words = List.of("byte", "bytes", "rat", "rain", "trait", "train");

        System.out.println(findAllWordsInABoard(board, words));
    }

}
