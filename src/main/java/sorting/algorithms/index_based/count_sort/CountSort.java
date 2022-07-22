package sorting.algorithms.index_based.count_sort;

public class CountSort {


    public void countSort(int[] input, int n) {
        int k = maxOf(input, n);
        System.out.println(k);
        int[] count = new int[k + 1];
        int[] output = new int[n];

        for (int i = 0; i <= k; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int element = input[i];
            count[element] = count[element] + 1;
        }
        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int element = input[i];
            output[count[element] - 1] = element;
            count[element] = count[element] - 1;
        }

        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
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
