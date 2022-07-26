package sorting.algorithms.comparision_based.quick_sort;

import sorting.algorithms.comparision_based.quick_sort.partitions.HoarePartition;
import sorting.algorithms.comparision_based.quick_sort.partitions.LomutoPartition;

public class QuickSort {

    public void sortUsingLomutoPartition(int[] input, int n) {
        _sortUsingLomutoPartition(input, 0, n - 1);
    }

    private void _sortUsingLomutoPartition(int[] input, int low, int high) {
        if (low < high) {
            int p = new LomutoPartition().partition(input, low, high);
            _sortUsingLomutoPartition(input, low, p-1);
            _sortUsingLomutoPartition(input, p + 1, high);
        }
    }

    public void sortUsingHoarePartition(int[] input, int n) {
        _sortUsingHoarePartition(input, 0, n - 1);
    }

    private void _sortUsingHoarePartition(int[] input, int low, int high) {
        if (low < high) {
            int p = new HoarePartition().partition(input, low, high);
            _sortUsingHoarePartition(input, low, p);
            _sortUsingHoarePartition(input, p + 1, high);
        }
    }
}
