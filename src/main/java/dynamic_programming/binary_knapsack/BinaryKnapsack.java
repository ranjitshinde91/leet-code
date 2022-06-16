package dynamic_programming.binary_knapsack;

import java.util.HashMap;
import java.util.Map;

public class BinaryKnapsack {
    private final int[] values;
    private final int[] weights;
    private Map<String, Integer> cache;

    public BinaryKnapsack(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;
        this.cache = new HashMap<>();
    }

    public int memoization(int weight) {
        return _memoization(weights.length, weight);
    }

    private int _memoization(int n, int weight) {
        if (n == 0 || weight == 0) {
            return 0;
        }
        if (cache.containsKey(key(n, weight))) {
            System.out.println("fetching value from cache");
            return cache.get(key(n, weight));
        }
        if (weights[n - 1] > weight) {
            return _memoization(n - 1, weight);
        }
        int res = Math.max(
                values[n - 1] + _memoization(n - 1, weight - weights[n - 1]),
                _memoization(n - 1, weight)
        );
        cache.put(key(n, weight), res);
        return res;
    }

    private String key(int n, int m) {
        return n + "-" + m;
    }

    public long tabulation(int weight) {
        return _tabulation(weights.length, weight);
    }

    private int _tabulation(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        table[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (weights[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(
                            values[i - 1] + table[i - 1][j - weights[i - 1]],
                            table[i - 1][j]
                    );
                }
            }
        }
        printTable(table, m, n);
        return table[m][n];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + " ".repeat(5 - String.valueOf(table[i][j]).length()));
            }
            System.out.println();
        }
    }
}
