package heap.purchase_maximum_items;

import java.util.PriorityQueue;

public class PurchaseMaximumItems {
    public long maxItem(long[] input, long sum) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long l : input) {
            pq.add(l);
        }

        int totalIteams = 0;
        long availableAmount = sum;
        while (availableAmount >= pq.peek()) {
            availableAmount = availableAmount - pq.poll();
            totalIteams++;
        }
        return totalIteams;
    }
}
