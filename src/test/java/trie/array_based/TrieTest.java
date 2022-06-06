package trie.array_based;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    void shouldInsertNewWordsInTrie() {

        Trie trie = new Trie();

        trie.insert("bad");
        trie.insert("bat");
        trie.insert("geek");
        trie.insert("geeks");
        trie.insert("cat");
        trie.insert("cut");
        trie.insert("zoo");


        assertThat(trie.search("bad")).isTrue();
        assertThat(trie.search("bat")).isTrue();
        assertThat(trie.search("geek")).isTrue();
        assertThat(trie.search("cat")).isTrue();
        assertThat(trie.search("cut")).isTrue();
        assertThat(trie.search("cut")).isTrue();
        assertThat(trie.search("zoo")).isTrue();


        assertThat(trie.search("b")).isFalse();
        assertThat(trie.search("eek")).isFalse();
        assertThat(trie.search("eek")).isFalse();
        assertThat(trie.search("cu")).isFalse();
        assertThat(trie.search("cutt")).isFalse();

    }

    @Test
    void shouldReturnFalseWhenSearchOnEmptyTrie() {

        Trie trie = new Trie();

        assertThat(trie.search("b")).isFalse();
    }


    @Test
    void shouldDeleteWithoutDeletingAnyNode() {

        Trie trie = new Trie();

        trie.insert("geek");
        trie.insert("geeks");

        trie.delete("geeks");

        assertThat(trie.search("geeks")).isFalse();
        assertThat(trie.search("geek")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfANode() {

        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("bat");

        trie.delete("bad");

        assertThat(trie.search("bad")).isFalse();
        assertThat(trie.search("bat")).isTrue();
    }

    @Test
    void shouldDeleteWithDeletionOfEntireChain() {

        Trie trie = new Trie();
        trie.insert("zoo");

        trie.delete("zoo");

        assertThat(trie.search("zoo")).isFalse();
    }
}