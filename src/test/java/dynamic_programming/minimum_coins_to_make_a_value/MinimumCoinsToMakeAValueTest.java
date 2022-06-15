package dynamic_programming.minimum_coins_to_make_a_value;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCoinsToMakeAValueTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] coins, int value, int expected) {
        var minimumCoinsToMakeAValue = new MinimumCoinsToMakeAValue();

        int output = minimumCoinsToMakeAValue.memoization(coins, value);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void memoizationAlternativeWay(int[] coins, int value, int expected) {
        var minimumCoinsToMakeAValue = new MinimumCoinsToMakeAValue();

        int output = minimumCoinsToMakeAValue.memoizationAlternativeWay(coins, value);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] sizes, int rodSize, int expected) {
        var minimumCoinsToMakeAValue = new MinimumCoinsToMakeAValue();

        long output = minimumCoinsToMakeAValue.tabulation(sizes, rodSize);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{25, 10, 5}, 30, 2),
                Arguments.of(new int[]{9, 6, 5, 1}, 11, 2),
                Arguments.of(new int[]{9, 6, 5, 1}, 11, 2),
                Arguments.of(new int[]{9, 6, 5}, 4, Integer.MAX_VALUE)
        );
    }


}