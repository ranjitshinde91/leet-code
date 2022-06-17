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
        int secondLast = 0;
        int last = inputs[0];
        for (int i = 2; i <= n; i++) {
            int temp = Math.max(
                    secondLast + inputs[i - 1],
                    last
            );
            secondLast = last;
            last = temp;
        }
        return last;
    }
}
