package dynamic_programming.lonest_common_subquence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonSubsequenceTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(String first, String second, long expected) {
        var longestCommonSubsequence = new LongestCommonSubsequence();

        long output = longestCommonSubsequence.memoization(first, second);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(String first, String second, long expected) {
        var longestCommonSubsequence = new LongestCommonSubsequence();

        long output = longestCommonSubsequence.tabulation(first, second);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "def", 0)
        );
    }

}