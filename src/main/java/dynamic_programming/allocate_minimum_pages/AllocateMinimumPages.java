package dynamic_programming.allocate_minimum_pages;

public class AllocateMinimumPages {

    public int memoization(int[] pages, int numberOfStudents) {
        return _memoization(pages, pages.length, numberOfStudents);

    }

    private int _memoization(int[] pages, int index, int numberOfStudents) {
        if (numberOfStudents == 1) {
            return sumOf(pages, 0, index - 1);
        }
        if (index == 0) {
            return pages[0];
        }
        int minPagesPerStudent = Integer.MAX_VALUE;
        for (int i = 1; i < index; i++) {
            int res = Math.max(
                    sumOf(pages, i, index - 1),
                    _memoization(pages, i, numberOfStudents - 1)
            );
            if (res < minPagesPerStudent) {
                minPagesPerStudent = res;
            }
        }
        return minPagesPerStudent;
    }

    private int sumOf(int[] pages, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += pages[i];
        }
        return sum;
    }

    public int tabulation(int[] pages, int numberOfStudents) {
        int m = numberOfStudents;
        int n = pages.length;
        int[][] table = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            table[1][i] = sumOf(pages, 0, i - 1);
        }
        for (int i = 1; i <= m; i++) {
            table[i][1] = pages[0];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                table[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) {
                    table[i][j] = Math.min(
                            table[i][j],
                            Math.max(
                                    table[i - 1][k],
                                    sumOf(pages, k, j - 1)
                            )
                    );
                }
            }
        }
        printTable(table, m, n);
        return table[m][n];
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
