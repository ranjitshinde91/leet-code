package backtracking.rat_in_a_maze;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RatInAMazeTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[][] input, boolean expected) {
        var ratInAMaze = new RatInAMaze(input);

        boolean isPath = ratInAMaze.isPath();

        assertThat(isPath).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 1, 1},
                        {1, 1, 1, 1}
                }, true),
                Arguments.of(new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                }, false)
        );
    }
}