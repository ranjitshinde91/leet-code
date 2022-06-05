package heap.merge_k_sorted_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeKSortedArraysTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[][] input, List<Integer> expected) {
        var mergeKSortedArrays = new MergeKSortedArrays();

        List<Integer> elements = mergeKSortedArrays.mergeKArrays(input, input.length);

        assertThat(elements).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                ),
                Arguments.of(new int[][]{
                                {1, 2, 3, 4}
                                , {2, 2, 3, 4},
                                {5, 5, 6, 6},
                                {7, 8, 9, 9}
                        },
                        List.of(1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9))
        );
    }

}