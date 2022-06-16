package dynamic_programming.binary_knapsack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryKnapsackTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] values, int[] weights, int weight, int expected) {
        var binaryKnapsack = new BinaryKnapsack(values, weights);

        int output = binaryKnapsack.memoization(weight);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] values, int[] weights, int weight, int expected) {
        var binaryKnapsack = new BinaryKnapsack(values, weights);

        long output = binaryKnapsack.tabulation(weight);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{10, 40, 30, 50}, new int[]{5, 4, 6, 3}, 10, 90),
                Arguments.of(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50, 220)
        );
    }

}