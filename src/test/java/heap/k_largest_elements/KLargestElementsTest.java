package heap.k_largest_elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KLargestElementsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int k, List<Integer> expected) {
        var kLargestElements = new KLargestElements();

        List<Integer> elements = kLargestElements.kLargest(input, k, input.length);

        assertThat(elements).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{5, 15, 10, 20, 8}, 2, List.of(20, 15)),
                Arguments.of(new int[]{8, 6, 4, 10, 9}, 3, List.of(10, 9, 8))
        );
    }

}