package stack.the_celebrity_problem;

class Solution {
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int[][] array, int n) {
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < n; j++) {
                if (i != j && array[i][j] != 0) {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) {
                return i;
            }
        }
        return -1;
    }

    int celebrity1(int[][] array, int n) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (array[a][b] == 0) {
                b--;
            } else {
                a++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != a && (array[a][i] == 1 || array[i][a] == 0)) {
                return -1;
            }

        }
        return a;
    }
}