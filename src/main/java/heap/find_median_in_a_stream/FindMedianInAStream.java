package heap.find_median_in_a_stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAStream {
    private  final PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private  final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public  void insertHeap(int x) {
        maxHeap.add(x);
        balanceHeaps();
    }

    //Function to balance heaps.
    public  void balanceHeaps() {
        if (maxHeap.size() - minHeap.size() == 2) {
            int element = maxHeap.poll();
            minHeap.add(element);

        }
        // add your code here
    }

    //Function to return Median.
    public double getMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 != 0) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

}
