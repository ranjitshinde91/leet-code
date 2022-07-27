package sorting.problems.chocolate_distribution_problem;

import java.util.Arrays;

public class ChocolateDistributionProblem {

    public int diff(int[] input, int n, int m) {
        if (m > n) {
            return -1;
        }
        Arrays.sort(input);
        int diff = Integer.MAX_VALUE;
        for (int i = m - 1; i < n; i++) {
            if (input[i] - input[i - (m - 1)] < diff) {
                diff = input[i] - input[i - (m - 1)];
            }
        }
        return diff;
    }
}
