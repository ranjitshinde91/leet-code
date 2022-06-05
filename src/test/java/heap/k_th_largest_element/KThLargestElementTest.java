package heap.k_th_largest_element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KThLargestElementTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int k, int expected) {
        var kThLargestElement = new KThLargestElement();

        int kthlargest = kThLargestElement.KthLargest(input, input.length, k);

        assertThat(kthlargest).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{5, 15, 10, 20, 8}, 2, 15),
                Arguments.of(new int[]{8, 6, 4, 10, 9}, 3, 8)
        );
    }

}