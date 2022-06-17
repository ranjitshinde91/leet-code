package dynamic_programming.subset_sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetSumTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int sum, int expected) {
        var subsetSum = new SubsetSum();

        var output = subsetSum.memoization(input, sum);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] inputs, int sum, int expected) {
        var subsetSum = new SubsetSum();

        var output = subsetSum.tabulation(inputs, sum);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 3, 6}, 8, 2),
                Arguments.of(new int[]{1, 2, 3}, 4, 1),
                Arguments.of(new int[]{10, 20, 15}, 37, 0),
                Arguments.of(new int[]{10, 20, 15}, 0, 1)
        );
    }
}