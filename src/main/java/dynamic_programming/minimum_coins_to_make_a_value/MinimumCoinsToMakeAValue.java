package dynamic_programming.minimum_coins_to_make_a_value;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoinsToMakeAValue {
    private final Map<String, Integer> cache;

    public MinimumCoinsToMakeAValue() {
        cache = new HashMap<>();
    }

    private String key(int m, int n) {
        return m + "-" + n;
    }

    public int memoization(int[] coins, int value) {
        return _memoization(coins, coins.length, value);
    }

    private int _memoization(int[] coins, int m, int n) {
        if (n == 0) {
            return 0;
        }
        if (m <= 0) {
            return Integer.MAX_VALUE;
        }
        if (cache.containsKey(key(m, n))) {
            return cache.get(key(m, n));
        }
        int includedResult = Integer.MAX_VALUE;
        if (coins[m - 1] <= n) {
            includedResult = _memoization(coins, m, (n - coins[m - 1]));
            if (includedResult != Integer.MAX_VALUE) {
                includedResult = includedResult + 1;
            }
        }
        int notIncludedResult = _memoization(coins, m - 1, n);
        int min = Math.min(includedResult, notIncludedResult);
        cache.put(key(m, n), min);
        return min;
    }

    public int memoizationAlternativeWay(int[] coins, int n) {
        return _memoizationAlternativeWay(coins, coins.length, n);
    }

    private int _memoizationAlternativeWay(int[] coins, int m, int n) {
        if (n == 0) {
            return 0;
        }
        if (m <= 0) {
            return Integer.MAX_VALUE;
        }
        if (cache.containsKey(key(m, n))) {
            return cache.get(key(m, n));
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (coins[i] <= n) {
                int i1 = _memoizationAlternativeWay(coins, m, n - coins[i]);
                if (i1 != Integer.MAX_VALUE) {
                    res = Math.min(res, i1 + 1);
                }
            }
        }
        cache.put(key(m, n), res);
        return res;
    }

    public long tabulation(int[] coins, int value) {
        int n = value;
        int[] table = new int[n + 1];

        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    table[i] = Math.min(table[i], table[i - coin] + 1);
                }
            }
        }
        printTable(table, n);
        return table[n];
    }

    private void printTable(int[] table, int n) {
        for (int j = 0; j <= n; j++) {
            System.out.print(table[j] + "  ");
        }
    }
}
