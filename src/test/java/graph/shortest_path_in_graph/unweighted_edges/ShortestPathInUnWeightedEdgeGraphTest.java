package graph.shortest_path_in_graph.unweighted_edges;

import graph.GraphAdjacencyListBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static graph.GraphType.DIRECTED;
import static graph.GraphType.UNDIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathInUnWeightedEdgeGraphTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void undirectedEdges(String input, int source, int[] expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = new GraphAdjacencyListBuilder().build(input, UNDIRECTED);
        var shortestPathInAnUndirectedGraph = new ShortestPathInUnWeightedEdgeGraph();

        int[] paths = shortestPathInAnUndirectedGraph.bfsBased(adjacencyList, source);

        assertThat(paths).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void directedEdges(String input, int source, int[] expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = new GraphAdjacencyListBuilder().build(input, DIRECTED);
        var shortestPathInAnUndirectedGraph = new ShortestPathInUnWeightedEdgeGraph();

        int[] paths = shortestPathInAnUndirectedGraph.bfsBased(adjacencyList, source);

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
                        , 0,
                        new int[]{0, 1, 1, 2}),
                Arguments.of(
                        "4 4\n" +
                                "0 1\n" +
                                "2 3\n" +
                                "0 2\n" +
                                "0 3"
                        , 0, new int[]{0, 1, 1, 1}),
                Arguments.of(
                        "4 4\n" +
                                "1 0\n" +
                                "2 3\n" +
                                "0 2\n" +
                                "0 3"
                        , 1, new int[]{1, 0, 2, 2}),
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
                        , 0, new int[]{0, 1, 1, 2, 1, 2})
        );
    }
}