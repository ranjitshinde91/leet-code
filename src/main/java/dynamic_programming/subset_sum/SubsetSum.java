package dynamic_programming.subset_sum;

public class SubsetSum {

    public int memoization(int[] input, int sum) {
        return _memoization(input, input.length, sum);
    }

    private int _memoization(int[] input, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (input[n - 1] > sum) {
            return _memoization(input, n - 1, sum);
        }
        return _memoization(input, n - 1, sum - input[n - 1]) +
                _memoization(input, n - 1, sum);
    }

    public int tabulation(int[] inputs, int sum) {
        int n = inputs.length;
        int[][] table = new int[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                if (inputs[j - 1] > i) {
                    table[i][j] = table[i][j - 1];
                } else {
                    table[i][j] = table[i - inputs[j - 1]][j - 1] + table[i][j - 1];
                }
            }
        }
        printTable(table, sum, n);
        return table[sum][n];
    }

    private void printTable(int[][] table, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
