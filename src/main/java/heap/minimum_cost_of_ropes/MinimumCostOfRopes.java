package heap.minimum_cost_of_ropes;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public long minCost(long[] arr, int n) {

        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.add(arr[i]);
        }

        long totalCost = 0;
        while (heap.size() > 1) {
            long first = heap.poll();
            long second = heap.poll();
            long newRopeSize = first + second;
            totalCost = totalCost + newRopeSize;
            heap.add(newRopeSize);
        }
        return totalCost;
    }
}
