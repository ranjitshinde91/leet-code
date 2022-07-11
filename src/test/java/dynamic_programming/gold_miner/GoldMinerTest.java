package dynamic_programming.gold_miner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GoldMinerTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[][] mine, int expected) {
        var goldMine = new GoldMiner();

        long output = goldMine.mine(mine);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 3, 3},
                                {2, 1, 4},
                                {0, 6, 4}
                        }, 12),
                Arguments.of(
                        new int[][]{
                                {1, 3, 1, 5},
                                {2, 2, 4, 1},
                                {5, 0, 2, 3},
                                {0, 6, 1, 2}
                        }, 16),
                Arguments.of(
                        new int[][]{
                                {10, 33, 13, 15},
                                {22, 21, 4, 1},
                                {5, 0, 2, 3},
                                {0, 6, 14, 2}
                        }, 83)
        );
    }
}

