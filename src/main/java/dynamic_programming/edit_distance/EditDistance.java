package dynamic_programming.edit_distance;

public class EditDistance {


    public int calculate(String first, String second) {
        if (first.isEmpty()) {
            return second.length();
        }
        if (second.isEmpty()) {
            return first.length();
        }
        if (first.charAt(first.length() - 1) == second.charAt(second.length() - 1)) {
            return calculate(removeLastChar(first), removeLastChar(second));
        }
        return 1 + min(
                calculate(first, removeLastChar(second)),
                calculate(removeLastChar(first), removeLastChar(second)),
                calculate(removeLastChar(first), second)
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

    String removeLastChar(String str) {
        if (str.length() == 1) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public int calculateTabulation(String first, String second) {

        int[][] table = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= second.length(); i++) {
            table[0][i] = i;
        }
        for (int i = 0; i <= first.length(); i++) {
            table[i][0] = i;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
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
        return table[first.length()][second.length()];
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
