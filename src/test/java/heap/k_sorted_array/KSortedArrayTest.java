package heap.k_sorted_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KSortedArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int k, int[] expected) {
        var kSortedArray = new KSortedArray();

        kSortedArray.sort(input, k, input.length);

        assertThat(input).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{9, 8, 7, 18, 19, 17}, 2, new int[]{7, 8, 9, 17, 18, 19}),
                Arguments.of(new int[]{10, 9, 8, 7, 4, 70, 50, 60}, 4, new int[]{4, 7, 8, 9, 10, 50, 60, 70}),
                Arguments.of(new int[]{6, 5, 3, 2, 8, 10, 9}, 3, new int[]{2, 3, 5, 6, 8, 9, 10})
        );
    }

}