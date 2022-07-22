package sorting.algorithms.heap_sort;

import heap.min_heap.MinHeap;

public class HeapSort {

    public void heapSort(int[] input, int n) {

        MinHeap minHeap = MinHeap.build(input);

        for (int i = 0; i < n; i++) {
            input[i] = minHeap.deleteMin();
        }
    }
}
