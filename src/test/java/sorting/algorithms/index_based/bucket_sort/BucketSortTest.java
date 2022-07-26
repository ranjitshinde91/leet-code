package sorting.algorithms.index_based.bucket_sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BucketSortTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int[] expected) {
        var bucketSort = new BucketSort();

        bucketSort.bucketSort(input, input.length, 3);

        assertThat(input).containsExactly(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 6, 5, 2},
                        new int[]{2, 5, 5, 6}
                ),
                Arguments.of(
                        new int[]{1, 4, 2, 5, 3, 0},
                        new int[]{0, 1, 2, 3, 4, 5}
                )
        );
    }
}