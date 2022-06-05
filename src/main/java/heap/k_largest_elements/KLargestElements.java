package heap.k_largest_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {


    public static ArrayList<Integer> kLargestUsingMaxHeap(int[] arr, int k, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            pq.add(i);
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }
        return list;
    }

    public static ArrayList<Integer> kLargest(int[] arr, int k, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
