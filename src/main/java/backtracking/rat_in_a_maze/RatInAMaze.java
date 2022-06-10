package backtracking.rat_in_a_maze;

public class RatInAMaze {

    private final int[][] input;
    private final int n;
    private final int[][] solution;

    public RatInAMaze(int[][] input) {
        this.input = input;
        this.n = input.length;
        solution = new int[n][n];
    }

    public boolean isPath() {
        if (_isPath(0, 0)) {
            printPath();
            return true;
        }
        return false;
    }

    private void printPath() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution[i][j] == 1) {
                    System.out.println(i + " : " + j);
                }
            }
        }
    }

    private boolean _isPath(int row, int column) {
        if (row == n - 1 && column == n - 1) {
            return true;
        }
        if (isSafe(input, row, column, n)) {
            solution[row][column] = 1;
            if (_isPath(row + 1, column)) return true;
            if (_isPath(row, column + 1)) return true;
            solution[row][column] = 0;
            return false;
        }
        return false;
    }

    private boolean isSafe(int[][] input, int row, int column, int n) {
        return row < n && column < n && input[row][column] == 1;
    }
}
