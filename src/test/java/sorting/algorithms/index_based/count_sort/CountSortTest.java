package sorting.algorithms.index_based.count_sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountSortTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int[] expected) {
        var countSort = new CountSort();

        countSort.countSort(input, input.length);

        assertThat(input).containsExactly(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 6, 5, 2},
                        new int[]{2, 5, 5, 6}
                ),
                Arguments.of(
                        new int[]{1, 4, 4, 1, 0, 1},
                        new int[]{0, 1, 1, 1, 4, 4}
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1}
                ),
                Arguments.of(
                        new int[]{1, -1, 0, 2, -2},
                        new int[]{-2, -1, 0, 1, 2}
                )
        );
    }

    @Test
    public void forString() {
        var countSort = new CountSort();

        String result = countSort.countSort("edsab");

        assertThat(result).isEqualTo("abdes");
    }
}