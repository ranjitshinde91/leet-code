package trie.count_distinct_rows_in_in_a_binary_matrix;

import trie.map_based.Trie;

public class CountDistinctRowsInABinaryMatrix {


    public int count(int[][] input) {

        Trie trie = new Trie();

        for (int[] ints : input) {
            StringBuilder row = new StringBuilder();
            for (int element : ints) {
                row.append(element);
            }
            trie.insert(row.toString());
        }

        return trie.totalWords();
    }
}
