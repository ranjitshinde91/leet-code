package trie;

import static trie.TrieNode.ALPHABET_COUNT;

class TrieNode {
    public static final int ALPHABET_COUNT = 26;
    TrieNode[] children = new TrieNode[ALPHABET_COUNT];
    boolean isEndOfWord;

    public boolean contains(Character ch) {
        return this.children[indexOf(ch)] != null;
    }

    public TrieNode get(Character ch) {
        return this.children[indexOf(ch)];
    }

    public void add(Character ch, TrieNode node) {
        this.children[indexOf(ch)] = node;

    }

    public void isEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    private int indexOf(Character character) {
        return character - 'a';
    }
}

public class TrieOperations {

    private final TrieNode rootNode;

    public TrieOperations() {
        rootNode = new TrieNode();
    }


    public void insert(String word) {
        _insert(rootNode, word);
    }

    private void _insert(TrieNode node, String word) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (!current.contains(ch)) {
                TrieNode newNode = new TrieNode();
                current.add(ch, newNode);
            }
            current = current.get(ch);
        }
        current.isEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = rootNode;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (!current.contains(character)) {
                return false;
            }
            current = current.get(character);
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


