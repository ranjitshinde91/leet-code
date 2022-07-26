package sorting.algorithms.comparision_based.merge_sort;

public class MergeSort {

    public void mergeSort(int[] input, int n) {
        _mergeSort(input, 0, n - 1);
    }

    private void _mergeSort(int[] input, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            _mergeSort(input, low, mid);
            _mergeSort(input, mid + 1, high);
            merge(input, low, mid, high);
        }
    }

    private void merge(int[] input, int low, int mid, int high) {
        int[] temp = new int[input.length];

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (input[j] < input[i]) {
                temp[k] = input[j];
                j++;
            } else {
                temp[k] = input[i];
                i++;
            }
            k++;
        }
        for (; i <= mid; i++) {
            temp[k++] = input[i];
        }
        for (; j <= high; j++) {
            temp[k++] = input[j];
        }

        for (int i1 = low; i1 <= high; i1++) {
            input[i1] = temp[i1];
        }
    }

}
