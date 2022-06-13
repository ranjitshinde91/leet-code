package dynamic_programming.edit_distance;

public class EditDistance {

    public int memoization(String first, String second) {
        return memoization(first, second, first.length(), second.length());
    }

    private int memoization(String first, String second, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            return memoization(first, second, m - 1, n - 1);
        }
        return 1 + min(
                memoization(first, second, m, n - 1),
                memoization(first, second, m - 1, n - 1),
                memoization(first, second, m - 1, n)
        );
    }

    private int min(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        }
        return c;
    }

    public int tabulation(String first, String second) {
        int m = first.length();
        int n = second.length();

        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            table[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + min(
                            table[i][j - 1],
                            table[i - 1][j - 1],
                            table[i - 1][j]
                    );
                }
            }
        }
        printTable(table);
        return table[m][n];
    }

    private void printTable(int[][] table) {
        for (int[] row : table) {
            for (int i : row) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}
