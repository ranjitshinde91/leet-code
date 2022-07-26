package sorting.algorithms.comparision_based.insertion_sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InsertionSortTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int[] expected) {
        var insertionSort = new InsertionSort();

        insertionSort.insertionSort(input, input.length);

        assertThat(input).containsExactly(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 1, 3, 9, 7},
                        new int[]{1, 3, 4, 7, 9}
                ),
                Arguments.of(
                        new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 2, 3, 4, 5}
                )
        );
    }
}