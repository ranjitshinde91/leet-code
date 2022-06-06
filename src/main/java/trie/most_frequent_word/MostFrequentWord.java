package trie.most_frequent_word;

import java.util.LinkedHashMap;
import java.util.Map;

public class MostFrequentWord {

    public String mostFrequentWord(String[] dict, int n) {
        TrieNode rootNode = new TrieNode();

        for (int i = 0; i < dict.length; i++) {
            insert(rootNode, dict[i], i);
        }
        return mostFrequentWord(rootNode).word;
    }

    private void insert(TrieNode node, String word, int index) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (!current.contains(character)) {
                TrieNode newNode = new TrieNode();
                current.children.put(character, newNode);
            }
            current = current.get(character);
        }
        if (current.firstIndex == -1) {
            current.firstIndex = index;
        }
        current.isWord(true);
        current.incrementCount();
    }

    private WordOccurrence mostFrequentWord(TrieNode node) {
        if (node.children.isEmpty() && node.isWord) {
            return new WordOccurrence("", node.count, node.firstIndex);
        }
        WordOccurrence frequentWord = null;
        for (Map.Entry<Character, TrieNode> children : node.children.entrySet()) {
            WordOccurrence childrenFrequency = mostFrequentWord(children.getValue());
            if (frequentWord == null || hasMoreFrequency(childrenFrequency, frequentWord)) {
                frequentWord = new WordOccurrence(children.getKey() + childrenFrequency.word, childrenFrequency.frequency, childrenFrequency.firstIndex);
            }
        }
        if (node.isWord && hasMoreFrequency(node, frequentWord)) {
            return new WordOccurrence("", node.count, node.firstIndex);
        }
        return frequentWord;
    }

    private boolean hasMoreFrequency(TrieNode node, WordOccurrence frequentWord) {
        return node.count > frequentWord.frequency || (node.count == frequentWord.frequency && node.firstIndex > frequentWord.firstIndex);
    }

    private boolean hasMoreFrequency(WordOccurrence childrenFrequency, WordOccurrence frequentWord) {
        return childrenFrequency.frequency > frequentWord.frequency || (childrenFrequency.frequency == frequentWord.frequency && childrenFrequency.firstIndex > frequentWord.firstIndex);
    }

}

class TrieNode {
    public Map<Character, TrieNode> children = new LinkedHashMap<>();
    public int count;
    public boolean isWord;
    public int firstIndex = -1;

    public void incrementCount() {
        this.count++;
    }

    public void isWord(boolean isWord) {
        this.isWord = isWord;
    }

    public TrieNode get(Character character) {
        return this.children.get(character);
    }

    public boolean contains(Character character) {
        return this.children.containsKey(character);
    }

}

class WordOccurrence {
    public String word;
    public int frequency;
    public int firstIndex;

    public WordOccurrence(String word, int frequency, int firstIndex) {
        this.word = word;
        this.frequency = frequency;
        this.firstIndex = firstIndex;
    }
}
