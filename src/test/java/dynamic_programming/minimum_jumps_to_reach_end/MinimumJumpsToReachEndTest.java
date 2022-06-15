package dynamic_programming.minimum_jumps_to_reach_end;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumJumpsToReachEndTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] jumps, int expected) {
        var minimumJumpsToReachEnd = new MinimumJumpsToReachEnd();

        long output = minimumJumpsToReachEnd.memoization(jumps);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] jumps, int expected) {
        var minimumJumpsToReachEnd = new MinimumJumpsToReachEnd();

        long output = minimumJumpsToReachEnd.tabulation(jumps);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 2, 1, 2, 1}, 2),
                Arguments.of(new int[]{4, 1, 5, 3, 1, 3, 2, 1, 8}, 3),
                Arguments.of(new int[]{0, 1, 1, 1, 1}, -1),
                Arguments.of(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}, 3),
                Arguments.of(new int[]{0,40,88,92,12,93,12,17,85,23,7,30,56,64,34,45,73,28,87,20,22,7,83,59,91,26,59,5,79,26,99,79,32,52,70,11,44,83,28,95,72,1,91,27,65,25,38}, -1)
        );
    }

}