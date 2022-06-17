package dynamic_programming.egg_dropping_puzzle.minimum_trials;

import java.util.HashMap;
import java.util.Map;

public class EggDroppingMinimumTrials {
    private Map<String, Integer> cache;

    public EggDroppingMinimumTrials() {
        this.cache = new HashMap<>();
    }

    public int memoization(int floors, int eggs) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (cache.containsKey(key(floors, eggs))) {
            return cache.get(key(floors, eggs));
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int res = 1 + Math.max(
                    memoization(i - 1, eggs - 1),
                    memoization(floors - i, eggs)
            );
            if (res < min) {
                min = res;
            }
        }
        cache.put(key(floors, eggs), min);
        return min;
    }

    private String key(int floors, int eggs) {
        return floors + "-" + eggs;
    }

    public long tabulation(int floors, int eggs) {
        int[][] table = new int[floors + 1][eggs + 1];
        for (int egg = 1; egg <= eggs; egg++) {
            table[1][egg] = 1;
        }
        for (int floor = 1; floor <= floors; floor++) {
            table[floor][1] = floor;
        }

        for (int floor = 2; floor <= floors; floor++) {
            for (int egg = 2; egg <= eggs; egg++) {
                int min = Integer.MAX_VALUE;
                for (int x = 1; x <= floor; x++) {
                    int res = 1 + Math.max(
                            table[x - 1][egg - 1],
                            table[floor - x][egg]
                    );
                    if (res < min) {
                        min = res;
                    }
                }
                table[floor][egg] = min;
            }
        }
        printTable(table, floors, eggs);
        return table[floors][eggs];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + " ".repeat(5 - String.valueOf(table[i][j]).length()));
            }
            System.out.println();
        }
    }
}
