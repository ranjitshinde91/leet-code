package sorting.algorithms.comparision_based.insertion_sort;

public class InsertionSort {

    public void insertionSort(int[] input, int n) {
        for (int i = 1; i < n; i++) {
            int temp = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
        }
    }
}
