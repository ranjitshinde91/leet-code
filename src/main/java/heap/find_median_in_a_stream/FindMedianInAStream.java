package heap.find_median_in_a_stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAStream {
    private final PriorityQueue<Integer> greaterHalf = new PriorityQueue<Integer>();
    private final PriorityQueue<Integer> smallerHalf = new PriorityQueue<>(Collections.reverseOrder());

    public void insertHeap(int x) {
        if (smallerHalf.size() > greaterHalf.size()) {
            if (smallerHalf.peek() > x) {
                greaterHalf.add(smallerHalf.poll());
                smallerHalf.add(x);
            } else {
                greaterHalf.add(x);
            }
        } else {
            if (smallerHalf.isEmpty() || x <= smallerHalf.peek()) {
                smallerHalf.add(x);
            } else {
                greaterHalf.add(x);
                smallerHalf.add(greaterHalf.poll());
            }
        }
    }

    //Function to balance heaps.
    public void balanceHeaps() {
        // add your code here
    }

    //Function to return Median.
    public double getMedian() {
        if ((smallerHalf.size() + greaterHalf.size()) % 2 != 0) {
            return smallerHalf.peek();
        } else {
            return (smallerHalf.peek() + greaterHalf.peek()) / 2;
        }
    }
}
