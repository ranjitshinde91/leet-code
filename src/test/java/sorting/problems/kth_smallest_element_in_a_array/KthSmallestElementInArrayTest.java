package sorting.problems.kth_smallest_element_in_a_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallestElementInArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int k, int expected) {
        var kthSmallestElementInArray = new KthSmallestElementInArray();

        int result = kthSmallestElementInArray.kthSmallest(input, input.length, k);

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        2,
                        2
                ),
                Arguments.of(
                        new int[]{7, 10, 4, 3, 20, 15},
                        3,
                        7
                ),
                Arguments.of(
                        new int[]{7, 10, 4, 3, 20, 15},
                        4,
                        10
                ),
                Arguments.of(
                        new int[]{10, 4, 5, 8, 11, 6, 26},
                        5,
                        10
                )
        );
    }

}