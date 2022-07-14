package graph.shortest_path_in_graph.weighted_edges.dijkstra_algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraAlgorithmTest {


    @ParameterizedTest
    @MethodSource("optimizedUnDirectedEdges")
    void test(int[][] grid, int source, int[] expected) {

        var dijkstraAlgorithm = new DijkstraAlgorithm();

        var result = dijkstraAlgorithm.shortestPath(grid, source);

        assertThat(result).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("optimizedUnDirectedEdges")
    void optimizedUnDirectedEdges(int[][] grid, int source, int[] expected) {

        var dijkstraAlgorithm = new DijkstraAlgorithm();

        var result = dijkstraAlgorithm.optimized(grid, source);

        assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> optimizedUnDirectedEdges() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 5, 10, 0},
                                {5, 0, 3, 20},
                                {10, 3, 0, 2},
                                {0, 20, 2, 0}
                        },
                        0,
                        new int[]{0, 5, 8, 10}
                ),
                Arguments.of(
                        new int[][]{
                                {0, 5, 3},
                                {5, 0, 1},
                                {3, 1, 0},
                        },
                        1,
                        new int[]{4, 0, 1}
                ),
                Arguments.of(
                        new int[][]{
                                {0, 4, 8},
                                {4, 0, -10},
                                {8, -10, 0},
                        },
                        0,
                        new int[]{0, 4, -6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("optimizedDirectedEdges")
    void optimizedDirectedEdges(int[][] grid, int source, int[] expected) {

        var dijkstraAlgorithm = new DijkstraAlgorithm();

        var result = dijkstraAlgorithm.optimized(grid, source);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> optimizedDirectedEdges() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 5, 0},
                                {0, 0, 2},
                                {3, 0, 0},
                        },
                        1,
                        new int[]{5, 0, 2}
                )
        );
    }
}