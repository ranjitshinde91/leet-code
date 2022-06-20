package dynamic_programming.matrix_chain_multiplication;

import java.util.HashMap;
import java.util.Map;

public class MatrixChainMultiplication {
    private Map<String, Integer> cache;

    public MatrixChainMultiplication() {
        this.cache = new HashMap<>();
    }

    public int memoization(int[] input) {
        return _memoization(input, 0, input.length - 1);
    }

    private int _memoization(int[] input, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (this.cache.containsKey(key(i, j))) {
            System.out.println("retrieving from cache");
            return cache.get(key(i, j));
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(
                    res,
                    _memoization(input, i, k) + _memoization(input, k, j) + (input[i] * input[k] * input[j])
            );
        }
        cache.put(key(i, j), res);
        return res;
    }

    private String key(int i, int j) {
        return i + "-" + j;
    }

    public int tabulation(int[] inputs) {
        int n = inputs.length;
        int[][] table = new int[n][n];

        for (int i = 0; i < n - 2; i++) {
            table[i][i + 1] = 0;
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                table[i][i + gap] = Integer.MAX_VALUE;
                for (int k = i + 1; k < i + gap; k++) {
                    table[i][i + gap] = Math.min(
                            table[i][i + gap],
                            table[i][k] + table[k][i + gap] + inputs[i] * inputs[k] * inputs[i + gap]
                    );
                }
            }
        }
        printTable(table, n - 1, n - 1);
        return table[0][n - 1];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + " ".repeat(7 - String.valueOf(table[i][j]).length()));
            }
            System.out.println();
        }
    }
}
