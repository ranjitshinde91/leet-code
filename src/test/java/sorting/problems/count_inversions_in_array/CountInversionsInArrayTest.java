package sorting.problems.count_inversions_in_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountInversionsInArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(long[] input, long expected) {
        var countInversionsInArray = new CountInversionsInArray();

        long result = countInversionsInArray.inversionCount(input, input.length);

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new long[]{2, 4, 1, 3, 5},
                        3
                ),
                Arguments.of(
                        new long[]{2, 3, 4, 5, 6},
                        0
                ),
                Arguments.of(
                        new long[]{10, 10, 10},
                        0
                )
        );
    }

}