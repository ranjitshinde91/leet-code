package dynamic_programming.matrix_chain_multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixChainMultiplicationTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int expected) {
        var matrixChainMultiplication = new MatrixChainMultiplication();

        var output = matrixChainMultiplication.memoization(input);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] inputs, int expected) {
        var matrixChainMultiplication = new MatrixChainMultiplication();

        var output = matrixChainMultiplication.tabulation(inputs);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{40, 20, 30, 10, 30}, 26000),
                Arguments.of(new int[]{10, 20, 30, 40, 30}, 30000),
                Arguments.of(new int[]{10, 20, 30}, 6000),
                Arguments.of(new int[]{2, 1, 3, 4}, 20),
                Arguments.of(new int[]{2, 1, 3}, 6)
        );
    }

}