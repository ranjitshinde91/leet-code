package heap.min_heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinHeapTest {

    @Test
    void shouldInsertElementInMinHeap() {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(50);

        int[] values = minHeap.values();

        assertThat(values).containsExactly(5, 10, 20, 30, 50);
    }

    @Test
    void shouldPerformHeapify() {
        MinHeap minHeap = new MinHeap(new int[]{40, 20, 30, 35, 25, 80, 32, 100, 70, 60});

        minHeap.heapify(0);

        var values = minHeap.values();
        assertThat(values).containsExactly(20, 25, 30, 35, 40, 80, 32, 100, 70, 60);
    }

    @Test
    void shouldDeleteMinElement() {
        MinHeap minHeap = new MinHeap(new int[]{20, 25, 30, 35, 40, 80, 32, 100, 70, 60});

        var minValue = minHeap.deleteMin();

        assertThat(minValue).isEqualTo(20);
        assertThat(minHeap.values()).containsExactly(25, 35, 30, 60, 40, 80, 32, 100, 70);
    }

    @Test
    void shouldDeleteKeyKey() {
        MinHeap minHeap = new MinHeap(new int[]{10, 20, 30, 40, 50, 35, 38, 45});

        minHeap.deleteKey(3);

        assertThat(minHeap.values()).containsExactly(10,20,30,45,50,35,38);
    }
}