package dynamic_programming.lonest_common_subquence;

import java.util.HashMap;
import java.util.Map;


public class LongestCommonSubsequence {

    private final Map<String, Integer> cache;

    public LongestCommonSubsequence() {
        this.cache = new HashMap<>();
    }

    public long memoization(String first, String second) {
        return _memoization(first, first.length(), second, second.length());
    }

    private Integer _memoization(String first, int m, String second, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (cache.containsKey(key(m, n))) {
            return cache.get(key(m, n));
        }
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            return 1 + _memoization(first, m - 1, second, n - 1);
        }
        int result = Math.max(
                _memoization(first, m, second, n - 1),
                _memoization(first, m - 1, second, n)
        );
        this.cache.put(key(m, n), result);
        return result;
    }

    private String key(int m, int n) {
        return m + "-" + n;
    }


    public Integer tabulation(String first, String second) {
        int m = first.length();
        int n = second.length();

        int[][] sequences = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    sequences[i][j] = 1 + sequences[i - 1][j - 1];
                } else {
                    sequences[i][j] = Math.max(sequences[i][j - 1], sequences[i - 1][j]);
                }
            }
        }
        return sequences[m][n];
    }
}
