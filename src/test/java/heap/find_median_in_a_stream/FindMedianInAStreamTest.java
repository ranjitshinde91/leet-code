package heap.find_median_in_a_stream;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void test4() {
        var findMedianInAStream = new FindMedianInAStream();
        List<Integer> numbers = List.of(9384, 887, 2778, 6916, 7794, 8336);
        List<Integer> outputs = List.of(9384, 5135, 2778, 4847, 6916, 7355);
        for (int i = 0; i < numbers.size(); i++) {
            findMedianInAStream.insertHeap(numbers.get(i));
            assertThat(findMedianInAStream.getMedian()).isEqualTo((double)outputs.get(i));
        }
    }
}

