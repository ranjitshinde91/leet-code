package dynamic_programming.maximum_cuts;

import java.util.HashMap;
import java.util.Map;


public class MaximumCutsForThreeSizes {

    private final Map<Integer, Integer> cache;

    public MaximumCutsForThreeSizes() {
        cache = new HashMap<>();
    }

    public int memoization(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (cache.containsKey(n)) {
            System.out.println("fetching ng from cache for size n :  " + n);
            return cache.get(n);
        }
        int res = max(
                memoization(n - a, a, b, c),
                memoization(n - b, a, b, c),
                memoization(n - c, a, b, c)
        );
        if (res == -1) {
            return res;
        }
        cache.put(n, res);
        return res + 1;
    }

    private int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }
        if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

    private void printTable(int[] table, int m) {
        for (int i = 0; i <= m; i++) {
            System.out.print(table[i] + "  ");
        }
    }

    public long tabulation(int n, int a, int b, int c) {
        int[] list = new int[n + 1];
        list[0] = 0;
        for (int i = 1; i <= n; i++) {
            list[i] = -1;

            if (i - a >= 0) {
                list[i] = Math.max(list[i], list[i - a]);
            }
            if (i - b >= 0) {
                list[i] = Math.max(list[i], list[i - b]);
            }
            if (i - c >= 0) {
                list[i] = Math.max(list[i], list[i - c]);
            }
            if (list[i] != -1) {
                list[i] = list[i] + 1;
            }
        }
        printTable(list, n);
        return list[n];
    }
}

