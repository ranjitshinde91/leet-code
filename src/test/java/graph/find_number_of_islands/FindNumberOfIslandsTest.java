package graph.find_number_of_islands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindNumberOfIslandsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void dfsBased(char[][] grid, int expected) {
        var findNumberOfIslands = new FindNumberOfIslands();

        long output = findNumberOfIslands.numIslands(grid);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'0', '1'},
                                {'1', '0'},
                                {'1', '1'},
                                {'1', '0'}
                        }, 1),
                Arguments.of(
                        new char[][]{
                                {'0', '1', '1', '1', '0', '0', '0'},
                                {'0', '0', '1', '1', '0', '1', '0'}
                        }, 2)
        );
    }
}