package sorting.algorithms.index_based.count_sort;

public class CountSort {


    public void countSort(int[] input, int n) {
        countSort(input, n, 1);
    }

    public void countSort(int[] input, int n, int exp) {
        int k = maxOf(input, n);
        int[] count = new int[k + 1];
        int[] output = new int[n];

        for (int i = 0; i <= k; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int element = getElement(input[i], exp);
            count[element] = count[element] + 1;
        }
        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int element = getElement(input[i], exp);
            output[count[element] - 1] = input[i];
            count[element] = count[element] - 1;
        }

        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
    }

    private int getElement(int input, int exp) {
        return (input / exp) % 10;
    }

    private int maxOf(int[] input, int n) {
        int max = input[0];
        for (int i = 1; i < n; i++) {
            if (max < input[i]) {
                max = input[i];
            }
        }
        return max;
    }
}
