package dynamic_programming.maximum_sum_with_no_two_consecutive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSumWithNoTwoConsecutiveTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] inputs, int expected) {
        var maximumSumWithNoTwoConsecutive = new MaximumSumWithNoTwoConsecutive();

        var output = maximumSumWithNoTwoConsecutive.memoization(inputs);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] jumps, int expected) {
        var maximumSumWithNoTwoConsecutive = new MaximumSumWithNoTwoConsecutive();

        var output = maximumSumWithNoTwoConsecutive.tabulation(jumps);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 2}, 10),
                Arguments.of(new int[]{8, 7, 6, 10}, 18),
                Arguments.of(new int[]{10, 5, 15, 20, 2, 30}, 60)
        );
    }

}