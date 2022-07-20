package sorting.problems.merge_two_sorted_arrays_without_extra_space;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedArraysWithoutExtraSpaceTest {


    @ParameterizedTest
    @MethodSource("inputs")
    public void test(long[] input1, long[] input2, long[] expected1, long[] expected2) {
        var mergeTwoSortedArraysWithoutExtraSpace = new MergeTwoSortedArraysWithoutExtraSpace();

        mergeTwoSortedArraysWithoutExtraSpace.merge(input1, input2, input1.length, input2.length);

        assertThat(input1).containsExactly(expected1);
        assertThat(input2).containsExactly(expected2);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new long[]{1, 3, 5, 7},
                        new long[]{0, 2, 6, 8, 9},
                        new long[]{0, 1, 2, 3},
                        new long[]{5, 6, 7, 8, 9}
                ),
                Arguments.of(
                        new long[]{10, 12},
                        new long[]{5, 18, 20},
                        new long[]{5, 10},
                        new long[]{12, 18, 20}
                )
        );
    }
}