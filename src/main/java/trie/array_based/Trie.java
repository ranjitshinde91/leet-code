package trie.array_based;


import static trie.array_based.TrieNode.ALPHABET_COUNT;

class TrieNode {
    public static final int ALPHABET_COUNT = 26;
    TrieNode[] children = new TrieNode[ALPHABET_COUNT];
    boolean isEndOfWord;

    public TrieNode() {
        this.isEndOfWord = false;
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            children[i] = null;
        }
    }
}

public class Trie {

    private final TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = rootNode;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                var newNode = new TrieNode();
                current.children[index] = newNode;
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = rootNode;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public void delete(String word) {
        _delete(rootNode, word, 0);
    }

    private TrieNode _delete(TrieNode node, String word, int index) {

        if (node == null) {
            return null;
        }
        if (index == word.length()) {
            node.isEndOfWord = false;
            if (isEmpty(node)) {
                return null;
            }
            return node;
        }
        int index2 = word.charAt(index) - 'a';

        node.children[index2] = _delete(node.children[index2], word, index + 1);
        if (isEmpty(node) && !node.isEndOfWord) {
            return null;
        }
        return node;
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }
}
