package ByteByteGo.Trie;

public class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        isWord = false;
    }
}
