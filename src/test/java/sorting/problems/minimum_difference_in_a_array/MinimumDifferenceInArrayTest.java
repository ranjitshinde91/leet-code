package sorting.problems.minimum_difference_in_a_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class MinimumDifferenceInArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input1, int expected) {
        var minimumDifferenceInArray = new MinimumDifferenceInArray();

        int result = minimumDifferenceInArray.diff(input1, input1.length);

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 4, 5, 9, 7},
                        1
                ),
                Arguments.of(
                        new int[]{10, 12},
                        2
                )
        );
    }

}