package dynamic_programming.count_bst_with_n_keys;

import dynamic_programming.minimum_jumps_to_reach_end.MinimumJumpsToReachEnd;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountBSTWithNKeysTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int n, long expected) {
        var countBSTWithNKeys = new CountBSTWithNKeys();

        long output = countBSTWithNKeys.memoization(n);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int n, int expected) {
        var countBSTWithNKeys = new CountBSTWithNKeys();

        int output = countBSTWithNKeys.tabulation(n);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(5, 42)
        );
    }

}