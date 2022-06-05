package heap.k_closest_elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KClosestElementsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int element, int k, List<Integer> expected) {
        var kClosestElements = new KClosestElements();

        List<Integer> elements = kClosestElements.closest(input, element, k);

        assertThat(elements).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 7, 3, 4}, 8, 2, List.of(7, 10)),
                Arguments.of(new int[]{100, 80, 10, 5, 70}, 2, 3, List.of(5, 10, 70)),
                Arguments.of(new int[]{20, 40, 5, 100, 150}, 100, 3, List.of(100, 150, 40))
        );
    }

}