package dynamic_programming.maximum_cuts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCutsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] sizes, int rodSize, int expected) {
        var maximumCuts = new MaximumCuts();

        int output = maximumCuts.memoization(sizes, rodSize);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] sizes, int rodSize, int expected) {
        var maximumCuts = new MaximumCuts();

        long output = maximumCuts.tabulation(sizes, rodSize);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 5, 5),
                Arguments.of(new int[]{6, 2, 3}, 5, 2),
                Arguments.of(new int[]{5, 3, 2}, 5, 2),
                Arguments.of(new int[]{94, 20, 244}, 9999, -1),
                Arguments.of(new int[]{12, 11, 13}, 23, 2),
                Arguments.of(new int[]{2, 4, 2}, 3, -1),
                Arguments.of(new int[]{10, 20, 50}, 100, 10),
                Arguments.of(new int[]{10, 20, 50}, 120, 12),
                Arguments.of(new int[]{10, 20, 50}, 75, -1)
        );
    }


}