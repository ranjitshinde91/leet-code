package heap.k_closest_elements;

import java.util.*;

public class KClosestElements {


    public List<Integer> closest(int[] input, int element, int k) {

        PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Element(input[i], Math.abs(input[i] - element)));
        }

        for (int i = k; i < input.length; i++) {
            if (Math.abs(input[i] - element) < pq.peek().difference()) {
                pq.poll();
                pq.add(new Element(input[i], Math.abs(input[i] - element)));
            }
        }

        while (!pq.isEmpty()) {
            list.add(pq.poll().value());
        }
        return list;

    }

    static class Element implements Comparable<Element> {
        private final int value;
        private final Integer difference;


        public Element(int value, int difference) {
            this.value = value;
            this.difference = difference;
        }

        public int value() {
            return this.value;
        }

        public Integer difference() {
            return this.difference;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.difference, other.difference);
        }
    }
}
