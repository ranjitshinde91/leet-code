package sorting.problems.kth_smallest_element_in_a_array;

import sorting.algorithms.quick_sort.partitions.LomutoPartition;

public class KthSmallestElementInArray {


    public int kthSmallest(int[] input, int n, int k) {
        int low = 0;
        int high = n - 1;
        LomutoPartition lomutoPartition = new LomutoPartition();

        while (low <= high) {
            int partition = lomutoPartition.partition(input, low, high);
            if (k - 1 == partition) {
                return input[partition];
            } else if (partition > k - 1) {
                high = partition - 1;
            } else {
                low = partition + 1;
            }
        }
        return -1;
    }
}
