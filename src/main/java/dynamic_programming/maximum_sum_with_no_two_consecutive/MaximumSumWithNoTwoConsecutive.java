package dynamic_programming.maximum_sum_with_no_two_consecutive;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumWithNoTwoConsecutive {
    private Map<Integer, Integer> cache;

    public MaximumSumWithNoTwoConsecutive() {
        this.cache = new HashMap<>();
    }

    public int memoization(int[] inputs) {
        return _memoization(inputs, inputs.length);
    }

    private int _memoization(int[] inputs, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return inputs[n - 1];
        }
        if (cache.containsKey(n)) {
            System.out.println("returning from cache for n : " + n);
            return cache.get(n);
        }
        int res = Math.max(
                _memoization(inputs, n - 2) + inputs[n - 1],
                _memoization(inputs, n - 1)
        );
        cache.put(n, res);
        return res;
    }

    public int tabulation(int[] inputs) {
        int n = inputs.length;
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = inputs[0];
        for (int i = 2; i <= n; i++) {
            table[i] = Math.max(
                    table[i - 2] + inputs[i - 1],
                    table[i - 1]
            );
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
