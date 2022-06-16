package dynamic_programming.optimal_strategy_for_a_game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OptimalStrategyForAGameTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void recursive(int[] jumps, int expected) {
        var optimalStrategyForAGame = new OptimalStrategyForAGame();

        long output = optimalStrategyForAGame.recursive(jumps);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] inputs, int expected) {
        var optimalStrategyForAGame = new OptimalStrategyForAGame();

        int output = optimalStrategyForAGame.memoization(inputs);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] inputs, int expected) {
        var optimalStrategyForAGame = new OptimalStrategyForAGame();

        int output = optimalStrategyForAGame.tabulation(inputs);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{20, 5, 4, 6}, 25),
                Arguments.of(new int[]{2, 3, 15, 7}, 17),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 12)
        );
    }


}