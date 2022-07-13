package graph.minimum_spanning_tree.prims_algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrimsAlgorithmTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test(int[][] grid, int expected) {

        var primsAlgorithm = new PrimsAlgorithm();

        var result = primsAlgorithm.minimumSpanningTree(grid);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void otherApproach(int[][] grid, int expected) {

        var primsAlgorithm = new PrimsAlgorithm();

        var result = primsAlgorithm.otherApproach(grid);

        assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 5, 8, 0},
                                {5, 0, 10, 15},
                                {8, 10, 0, 20},
                                {0, 15, 20, 0}
                        },
                        28
                ),
                Arguments.of(
                        new int[][]{
                                {0, 2, 0, 6, 0},
                                {2, 0, 3, 8, 5},
                                {0, 3, 0, 0, 7},
                                {6, 8, 0, 0, 9},
                                {0, 5, 7, 9, 0}
                        },
                        16
                )
        );
    }
}