package dynamic_programming.coin_change;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    private Map<String, Integer> cache;

    public CoinChange() {
        cache = new HashMap<>();
    }

    public int memoization(int[] coins, int sum) {
        return _memoization(coins, coins.length, sum);
    }

    private int _memoization(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (cache.containsKey(key(n, sum))) {
            System.out.println("getting from cache for " + n + " with sum : " + sum);
            cache.get(key(n, sum));
        }
        int res = _memoization(coins, n - 1, sum);
        if (coins[n - 1] <= sum) {
            res = res + _memoization(coins, n, sum - coins[n - 1]);
        }
        cache.put(key(n, sum), res);
        return res;
    }

    private String key(int n, int sum) {
        return n + ":" + sum;
    }

    public int tabulation(int[] coins, int sum) {
        return _calculateTabulation(coins, coins.length, sum);
    }

    private Integer _calculateTabulation(int[] coins, int n, int num) {
        int[][] table = new int[num + 1][n + 1];
        for (int i = 0; i < n; i++) {
            table[0][i] = 1;
        }
        for (int i = 0; i < num; i++) {
            table[i][0] = 0;
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (coins[j - 1] <= i) {
                    table[i][j] = table[i][j] + table[i - coins[j - 1]][j];
                }
            }
        }
        return table[num][n];
    }
}
