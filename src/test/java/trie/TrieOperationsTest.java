package trie;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieOperationsTest {

    @Test
    void shouldInsertNewWordsInTrie() {

        TrieOperations trieOperations = new TrieOperations();

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

        TrieOperations trieOperations = new TrieOperations();

        assertThat(trieOperations.search("b")).isFalse();
    }


    @Test
    void shouldDeleteWithoutDeletingAnyNode() {

        TrieOperations trieOperations = new TrieOperations();

        trieOperations.insert("geek");
        trieOperations.insert("geeks");

        trieOperations.delete("geeks");

        assertThat(trieOperations.search("geeks")).isFalse();
        assertThat(trieOperations.search("geek")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfANode() {

        TrieOperations trieOperations = new TrieOperations();
        trieOperations.insert("bad");
        trieOperations.insert("bat");

        trieOperations.delete("bad");

        assertThat(trieOperations.search("bad")).isFalse();
        assertThat(trieOperations.search("bat")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfEntireChain() {

        TrieOperations trieOperations = new TrieOperations();
        trieOperations.insert("zoo");

        trieOperations.delete("zoo");

        assertThat(trieOperations.search("zoo")).isFalse();
    }

}