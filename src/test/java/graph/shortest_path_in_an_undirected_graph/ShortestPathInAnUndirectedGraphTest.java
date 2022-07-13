package graph.shortest_path_in_an_undirected_graph;

import graph.GraphAdjacencyMatrixBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static graph.GraphType.UNDIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathInAnUndirectedGraphTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void bfsBased(String input, int[] expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = new GraphAdjacencyMatrixBuilder().build(input, UNDIRECTED);
        var shortestPathInAnUndirectedGraph = new ShortestPathInAnUndirectedGraph();

        int[] paths = shortestPathInAnUndirectedGraph.shortestPath(adjacencyList);

        assertThat(paths).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "4 5\n" +
                                "0 1\n" +
                                "0 2\n" +
                                "1 2\n" +
                                "2 3\n" +
                                "1 3"
                        , new int[]{0, 1, 1, 2}),
                Arguments.of(
                        "4 4\n" +
                                "0 1\n" +
                                "2 3\n" +
                                "0 2\n" +
                                "0 3"
                        , new int[]{0, 1, 1, 1}),
                Arguments.of(
                        "6 8\n" +
                                "0 1\n" +
                                "0 2\n" +
                                "0 4\n" +
                                "2 3\n" +
                                "2 4\n" +
                                "4 5\n" +
                                "3 5\n" +
                                "1 3"
                        , new int[]{0, 1, 1, 2, 1, 2})
        );
    }

}