package trie.map_based;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    void shouldInsertNewWordsInTrie() {

        Trie trieOperations = new Trie();

        trieOperations.insert("bad");
        trieOperations.insert("bat");
        trieOperations.insert("geek");
        trieOperations.insert("geeks");
        trieOperations.insert("cat");
        trieOperations.insert("cut");
        trieOperations.insert("zoo");


        assertThat(trieOperations.search("bad")).isTrue();
        assertThat(trieOperations.search("bat")).isTrue();
        assertThat(trieOperations.search("geek")).isTrue();
        assertThat(trieOperations.search("cat")).isTrue();
        assertThat(trieOperations.search("cut")).isTrue();
        assertThat(trieOperations.search("cut")).isTrue();
        assertThat(trieOperations.search("zoo")).isTrue();


        assertThat(trieOperations.search("b")).isFalse();
        assertThat(trieOperations.search("eek")).isFalse();
        assertThat(trieOperations.search("eek")).isFalse();
        assertThat(trieOperations.search("cu")).isFalse();
        assertThat(trieOperations.search("cutt")).isFalse();

    }

    @Test
    void shouldReturnFalseWhenSearchOnEmptyTrie() {

        Trie trieOperations = new Trie();

        assertThat(trieOperations.search("b")).isFalse();
    }


    @Test
    void shouldDeleteWithoutDeletingAnyNode() {

        Trie trieOperations = new Trie();

        trieOperations.insert("geek");
        trieOperations.insert("geeks");

        trieOperations.delete("geeks");

        assertThat(trieOperations.search("geeks")).isFalse();
        assertThat(trieOperations.search("geek")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfANode() {

        Trie trieOperations = new Trie();
        trieOperations.insert("bad");
        trieOperations.insert("bat");

        trieOperations.delete("bad");

        assertThat(trieOperations.search("bad")).isFalse();
        assertThat(trieOperations.search("bat")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfEntireChain() {
        Trie trie = new Trie();
        trie.insert("zoo");

        trie.delete("zoo");

        assertThat(trie.search("zoo")).isFalse();
    }
}