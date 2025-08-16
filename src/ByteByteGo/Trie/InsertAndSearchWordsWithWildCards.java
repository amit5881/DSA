package ByteByteGo.Trie;

public class InsertAndSearchWordsWithWildCards {

    private static TrieNode root;

    public InsertAndSearchWordsWithWildCards() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    private boolean search(String word) {
        return searchHelper(0, word, root);
    }

    public boolean searchHelper(int wordIndex, String word, TrieNode node) {
        for (int i = wordIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchHelper(i + 1, word, child)) {
                        return true;
                    }
                }
                return false;
            } else if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    public static void main(String[] args) {
        InsertAndSearchWordsWithWildCards trie = new InsertAndSearchWordsWithWildCards();
        trie.insert("band");
        trie.insert("rat");

        System.out.println(trie.search("ra."));
        System.out.println(trie.search("b.."));

        trie.insert("ran");
        System.out.println(trie.search(".an"));
    }
}
