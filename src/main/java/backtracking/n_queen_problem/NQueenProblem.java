package backtracking.n_queen_problem;

public class NQueenProblem {

    private final int n;
    private final int[][] queens;

    public NQueenProblem(int n) {
        this.n = n;
        queens = new int[n][n];
    }

    boolean isSafe(int row, int column) {
        return isSafeRow(row) &&
                isSafeDiagonal(row, column);
    }

    private boolean isSafeRow(int row) {
        for (int i = 0; i < n; i++) {
            if (isQueenPlaced(row, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeDiagonal(int row, int column) {
        return (isSafeTopLeft(row, column)) &&
                (isSafeTopRight(row, column)) &&
                (isSafeDownLeft(row, column)) &&
                (isSafeDownRight(row, column)) &&
                !isQueenPlaced(row, column);
    }

    private boolean isSafeTopRight(int row, int column) {
        int r = row - 1;
        int c = column + 1;
        while (r > 0 && c < n) {
            if (isQueenPlaced(r, c)) return false;
            r--;
            c++;
        }
        return true;
    }

    private boolean isSafeDownLeft(int row, int column) {
        int r = row + 1;
        int c = column - 1;
        while (r < n && c >= 0) {
            if (isQueenPlaced(r, c)) return false;
            r++;
            c--;
        }
        return true;
    }

    private boolean isSafeTopLeft(int row, int column) {
        int r = row - 1;
        int c = column - 1;
        while (c >= 0 && r >= 0) {
            if (isQueenPlaced(r, c)) return false;
            r--;
            c--;
        }
        return true;
    }

    private boolean isSafeDownRight(int row, int column) {
        int r = row + 1;
        int c = column + 1;
        while (c < n && r < n) {
            if (isQueenPlaced(r, c)) return false;
            r++;
            c++;
        }
        return true;
    }

    private boolean isQueenPlaced(int r, int c) {
        return queens[r][c] == 1;
    }

    public boolean canPlace() {
        if (placeQueen(0)) {
            for(int[] row :queens){
                for(int e : row){
                    System.out.print(e + "  ");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }

    private boolean placeQueen(int column) {
        if (column == n) return true;

        for (int row = 0; row < n; row++) {
            if (isSafe(row, column)) {
                queens[row][column] = 1;
                if (placeQueen(column + 1)) {
                    return true;
                }
                queens[row][column] = 0;
            }
        }
        return false;
    }
}
