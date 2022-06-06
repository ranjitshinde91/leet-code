package trie.operations_map_based;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord;

    public boolean contains(Character ch) {
        return this.children.containsKey(ch);
    }

    public TrieNode getChildren(Character ch) {
        return this.children.get(ch);
    }

    public void addChildren(Character ch, TrieNode node) {
        this.children.put(ch, node);
    }

    public void removeChildren(char character) {
        this.children.remove(character);
    }

    public void isEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public boolean hasChildren() {
        return this.children.size() > 0;
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
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
                current.addChildren(ch, newNode);
            }
            current = current.getChildren(ch);
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
            current = current.getChildren(character);
        }
        return current.isEndOfWord();
    }

    public void delete(String word) {
        _delete(rootNode, word, 0);
    }

    private void _delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            node.isEndOfWord(false);
            return;
        }
        TrieNode childNode = node.getChildren(word.charAt(index));
        _delete(childNode, word, index + 1);
        if (!(childNode.hasChildren() || childNode.isEndOfWord())) {
            node.removeChildren(word.charAt(index));
        }
    }
}


