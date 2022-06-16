package dynamic_programming.optimal_strategy_for_a_game;

public class OptimalStrategyForAGame {

    public int recursive(int[] inputs) {
        int sum = 0;
        for (int input : inputs) {
            sum += input;
        }
        return _recursiveStrategy1(inputs, 0, inputs.length - 1, sum);
    }

    private int _recursiveStrategy1(int[] inputs, int start, int end, int sum) {
        if (start == end) {
            return inputs[start];
        }
        return Math.max(
                sum - _recursiveStrategy1(inputs, start + 1, end, sum - inputs[start]),
                sum - _recursiveStrategy1(inputs, start, end - 1, sum - inputs[end])
        );
    }

    public int memoization(int[] inputs) {
        return _recursiveStrategy2(inputs, 0, inputs.length - 1);
    }

    private int _recursiveStrategy2(int[] inputs, int start, int end) {
        if (start + 1 == end) {
            return Math.max(inputs[start], inputs[end]);
        }
        return Math.max(
                inputs[start] + Math.min(
                        _recursiveStrategy2(inputs, start + 2, end),
                        _recursiveStrategy2(inputs, start + 1, end - 1)
                ),
                inputs[end] +
                        Math.min(
                                _recursiveStrategy2(inputs, start + 1, end - 1),
                                _recursiveStrategy2(inputs, start, end - 2)
                        )
        );
    }

    public int tabulation(int[] inputs) {
        int n = inputs.length;
        int[][] table = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            table[i][i + 1] = Math.max(inputs[i], inputs[i + 1]);
        }
        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                table[i][j] = Math.max(
                        inputs[i] + Math.min(table[i + 2][j], table[i + 1][j - 1]),
                        inputs[j] + Math.min(table[i + 1][j - 1], table[i][j - 2])
                );
            }
        }
        printTable(table, n-1, n-1);
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
}
