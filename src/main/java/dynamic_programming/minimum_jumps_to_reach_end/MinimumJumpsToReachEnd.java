package dynamic_programming.minimum_jumps_to_reach_end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumJumpsToReachEnd {

    Map<Integer, Integer> cache = new HashMap<>();

    public int tabulation(int[] jumps) {
        int end = jumps.length;
        int[] table = new int[jumps.length];
        table[0] = 0;
        List<Integer> lastIndexes = new ArrayList<>();
        lastIndexes.add(0);

        for (int i = 1; i < end; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int j = 0; j < lastIndexes.size(); j++) {
                int temp = lastIndexes.get(j);
                if (jumps[temp] >= (i - temp) && table[temp] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[temp] + 1);
                } else {
                    lastIndexes.remove(Integer.valueOf(temp));
                }
            }
            lastIndexes.add(i);
        }
        printTable(table, end - 1);
        if (table[end - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return table[end - 1];
    }

    private void printTable(int[] table, int n) {
        for (int j = 0; j <= n; j++) {
            System.out.print(table[j] + "  ");
        }
    }

    public int memoization(int[] jumps) {
        int res = _memoization(jumps, jumps.length);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private int _memoization(int[] jumps, int n) {
        if (n == 1) {
            return 0;
        }
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int minJumps = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (jumps[i] >= (n - 1 - i)) {
                int res = _memoization(jumps, i + 1);
                if (res != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, res + 1);
                }
            }
        }
        cache.put(n, minJumps);
        return minJumps;
    }

}
