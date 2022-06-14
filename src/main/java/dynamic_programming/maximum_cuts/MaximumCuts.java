package dynamic_programming.maximum_cuts;

import java.util.HashMap;
import java.util.Map;

public class MaximumCuts {

    private final Map<String, Integer> cache;

    public MaximumCuts() {
        cache = new HashMap<>();
    }

    public int memoization(int[] sizes, int rodSize) {
        return _memoization(sizes, sizes.length, rodSize);
    }

    private int _memoization(int[] sizes, int m, int n) {
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return -1;
        }
        if (cache.containsKey(key(m, n))) {
            System.out.println("fetching ng from cache (m,n) " + m + "-" + n);
            return cache.get(key(m, n));
        }
        int res = -1;
        if (sizes[m - 1] <= n) {
            res = _memoization(sizes, m, (n - sizes[m - 1]));
            if (res >= 0) {
                res++;
            }
        }
        int max = Math.max(res, _memoization(sizes, m - 1, n));
        cache.put(key(m, n), max);
        return max;
    }

    private String key(int m, int n) {
        return m + "-" + n;
    }

    public long tabulation(int[] sizes, int rodSize) {
        int m = sizes.length;
        int n = rodSize;

        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            table[0][i] = -1;
        }
        for (int i = 0; i <= m; i++) {
            table[i][0] = 0;
        }
        table[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int res = -1;
                if (sizes[i - 1] <= j) {
                    res = table[i][j - sizes[i - 1]];
                    if (res >= 0) {
                        res = res + 1;
                    }
                }
                table[i][j] = Math.max(res, table[i - 1][j]);
            }
        }
        printTable(table, m, n);
        return table[m][n];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }
    }

}

