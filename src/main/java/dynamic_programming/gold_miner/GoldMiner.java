package dynamic_programming.gold_miner;

import java.util.HashMap;
import java.util.Map;

public class GoldMiner {

    Map<String, Integer> cache = new HashMap<>();

    public int memoization(int[][] mine) {
        int res = 0;
        int n = mine.length;
        int m = mine[0].length;

        for (int i = 0; i < mine.length; i++) {
            int b = _mine(mine, i, 0, n, m);
            res = Math.max(res, b);
        }
        return res;
    }

    private int _mine(int[][] mine, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if (cache.containsKey(key(i, j))) {
            System.out.println("returning from cache for " + key(i, j));
            return cache.get(key(i, j));
        }
        int res = mine[i][j] + Math.max(
                Math.max(
                        _mine(mine, i + 1, j + 1, n, m),
                        _mine(mine, i - 1, j + 1, n, m)
                ),
                _mine(mine, i, j + 1, n, m)
        );
        cache.put(key(i, j), res);
        return res;
    }

    private String key(int i, int j) {
        return i + "-" + j;
    }

    public int tabulation(int[][] mine) {
        int n = mine.length;
        int m = mine[0].length;
        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            table[i][m - 1] = mine[i][m - 1];
        }
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                table[i][j] = mine[i][j] +
                        Math.max(
                                Math.max(
                                        valueOf(table, i + 1, j + 1, n, m),
                                        valueOf(table, i - 1, j + 1, n, m)
                                ),
                                valueOf(table, i, j + 1, n, m)
                        );
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, table[i][0]);
        }
        return max;
    }

    private int valueOf(int[][] table, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        return table[i][j];
    }
}
