package dynamic_programming.count_bst_with_n_keys;

import java.util.HashMap;
import java.util.Map;

public class CountBSTWithNKeys {
    private Map<Integer, Integer> cache;

    public CountBSTWithNKeys() {
        cache = new HashMap<>();
    }

    public int memoization(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + memoization(i - 1) * memoization(n - i);
        }
        cache.put(n, sum);
        return sum;
    }

    public int tabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long[] table = new long[n + 1];
        table[0] = 1;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            long sum = 0;
            for (int j = 1; j <= i; j++) {
                sum = sum + table[j - 1] * table[i - j];
            }
            table[i] = sum;
        }
        printTable(table, n);
        return (int) table[n];
    }

    private void printTable(long[] table, int n) {
        for (int j = 0; j <= n; j++) {
            System.out.print(table[j] + "  ");
        }
    }
}
