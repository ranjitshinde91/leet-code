package dynamic_programming.longest_increasing_subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestIncreasingSubsequenceTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] input, int expected) {
        var longestIncreasingSubsequence = new LongestIncreasingSubsequence();

        long output = longestIncreasingSubsequence.binarySearchTreeBased(input);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] input, int expected) {
        var longestIncreasingSubsequence = new LongestIncreasingSubsequence();

        long output = longestIncreasingSubsequence.tabulation(input);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{2}, 1),
                Arguments.of(new int[]{2, 5}, 2),
                Arguments.of(new int[]{2, 5, 1}, 2),
                Arguments.of(new int[]{2, 5, 1, 4}, 2),
                Arguments.of(new int[]{2, 5, 1, 4, 10, 10, 7}, 3),
                Arguments.of(new int[]{3, 4, 2, 8, 10}, 4),
                Arguments.of(new int[]{4, 10, 6, 5, 8, 11, 2, 20}, 5),
                Arguments.of(new int[]{10, 20, 30}, 3),
                Arguments.of(new int[]{30, 20, 10}, 1)
        );
    }

}