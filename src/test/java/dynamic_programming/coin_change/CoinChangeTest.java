package dynamic_programming.coin_change;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangeTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] coins, int sum, int expected) {
        var coinChange = new CoinChange();

        int output = coinChange.calculate(coins, sum);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] coins, int sum, int expected) {
        var coinChange = new CoinChange();

        int output = coinChange.calculateTabulation(coins, sum);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 4, 4),
                Arguments.of(new int[]{2, 5, 3, 6}, 10, 5)
        );
    }
}