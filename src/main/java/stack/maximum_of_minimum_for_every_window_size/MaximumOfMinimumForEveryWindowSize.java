package stack.maximum_of_minimum_for_every_window_size;

public class MaximumOfMinimumForEveryWindowSize {


    //O(n^3)
    public int[] maxOfMinNaive(int[] input, int n) {
        int[] maxOfMin = new int[n];

        for (int i = 0; i < n; i++) {
            for (int k = i; k >= 0; k--) {
                int min = minBetween(input, i - k, i);
                if (maxOfMin[k] < min) {
                    maxOfMin[k] = min;
                }
            }
        }
        return maxOfMin;
    }

    private int minBetween(int[] input, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if (input[k] < min) {
                min = input[k];
            }
        }
        return min;
    }

    public int[] maxOfMin(int[] input, int length) {
        return new int[0];
    }
}
