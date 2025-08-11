package ByteByteGo.Trie;

public class DesignATrie {

    private final TrieNode root;

    public DesignATrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isWord;
    }

    public boolean hasPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        DesignATrie trie = new DesignATrie();
        trie.insert("top");
        trie.insert("bye");
        System.out.println(trie.hasPrefix("to"));
        System.out.println(trie.search("to"));
        trie.insert("to");
        System.out.println(trie.search("to"));
    }

}
