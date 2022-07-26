package sorting.algorithms.index_based.radix_sort;

import sorting.algorithms.index_based.count_sort.CountSort;

public class RadixSort {


    public void radixSort(int[] input, int n) {
        CountSort countSort = new CountSort();
        int max = maxOf(input, n);
        for (int exp = 1; (max / exp) > 0; exp = exp * 10) {
            countSort.countSort(input, n, exp);
        }
    }

    private int maxOf(int[] input, int n) {
        int max = input[0];
        for (int i = 1; i < n; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }
}
