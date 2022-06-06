package trie.count_distinct_rows_in_in_a_binary_matrix;

import trie.map_based.Trie;

public class CountDistinctRowsInABinaryMatrix {


    public int count(int[][] input) {
        Trie trie = new Trie();
        int distinctRows = 0;

        for (int[] ints : input) {
            String row = row(ints);
            if (!trie.search(row)) {
                trie.insert(row);
                distinctRows++;
            }
        }
        return distinctRows;
    }

    private String row(int[] ints) {
        StringBuilder row = new StringBuilder();
        for (int element : ints) {
            row.append(element);
        }
        return row.toString();
    }
}
