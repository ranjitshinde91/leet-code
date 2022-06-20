package dynamic_programming.palindrome_partitioning;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningWithMinimumCuts {
    private Map<String, Integer> cache;

    public PalindromePartitioningWithMinimumCuts() {
        this.cache = new HashMap<>();
    }

    public int memoization(String string) {
        return _memoization(string, 0, string.length() - 1);
    }

    private int _memoization(String word, int start, int end) {
        if (isPalindrome(word, start, end)) {
            return 0;
        }
        if (start + 1 == end) {
            return 1;
        }
        if (cache.containsKey(key(start, end))) {
            System.out.println("retrieving from cache " + start + " : " + end);
            return cache.get(key(start, end));
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            res = Math.min(res,
                    1 + _memoization(word, start, i) + _memoization(word, i + 1, end)
            );
        }
        cache.put(key(start, end), res);
        return res;
    }

    private String key(int start, int end) {
        return start + ":" + end;
    }

    public int tabulation(String word) {
        int n = word.length();
        int[][] table = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            if (word.charAt(i) != word.charAt(i + 1)) {
                table[i][i + 1] = 1;
            }
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (isPalindrome(word, i, j)) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        table[i][j] = Math.min(
                                table[i][j],
                                1 + table[i][k] + table[k + 1][j]
                        );
                    }
                }
            }
        }
        printTable(table, n - 1, n - 1);
        return table[0][n - 1];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + " ".repeat(5 - String.valueOf(table[i][j]).length()));
            }
            System.out.println();
        }
    }

    private boolean isPalindrome(String word, int m, int n) {
        for (int i = m, j = n; i <= n; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
