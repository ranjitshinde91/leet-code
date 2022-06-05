package heap.find_median_in_a_stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindMedianInAStreamTest {

    @Test
    void test() {
        var findMedianInAStream = new FindMedianInAStream();

        findMedianInAStream.insertHeap(25);
        findMedianInAStream.balanceHeaps();

        assertThat(findMedianInAStream.getMedian()).isEqualTo(25.0);
    }

    @Test
    void test2() {
        var findMedianInAStream = new FindMedianInAStream();

        findMedianInAStream.insertHeap(25);
        findMedianInAStream.balanceHeaps();
        findMedianInAStream.insertHeap(7);
        findMedianInAStream.balanceHeaps();

        assertThat(findMedianInAStream.getMedian()).isEqualTo(16.0);
    }

    @Test
    void test3() {
        var findMedianInAStream = new FindMedianInAStream();

        findMedianInAStream.insertHeap(25);
        findMedianInAStream.balanceHeaps();
        findMedianInAStream.insertHeap(7);
        findMedianInAStream.balanceHeaps();
        findMedianInAStream.insertHeap(10);
        findMedianInAStream.balanceHeaps();

        assertThat(findMedianInAStream.getMedian()).isEqualTo(10.0);
    }
}