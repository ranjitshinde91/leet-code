package stack.the_celebrity_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TheCelebrityProblemUnitTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[][] input, int expected) {
        Solution solution = new Solution();

        int celebrity = solution.celebrity1(input, input.length);

        assertThat(celebrity).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1, 0,}, {0, 0, 0}, {0, 1, 0}}, 1),
                Arguments.of(new int[][]{{0, 1}, {1, 0}}, -1),
                Arguments.of(new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 0, 0}}, 3)
        );
    }

}

