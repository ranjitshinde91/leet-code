package sorting.problems.chocolate_distribution_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ChocolateDistributionProblemTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int m, int expected) {
        var chocolateDistributionProblem = new ChocolateDistributionProblem();

        int result = chocolateDistributionProblem.diff(input, input.length, m);

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{7, 3, 2, 4, 9, 12, 56},
                        3,
                        2
                ),
                Arguments.of(
                        new int[]{3, 4, 1, 9, 56, 7, 9, 12},
                        5,
                        6
                )
        );
    }

}