package graph.shortest_path_in_a_directed_acyclic_graph.topological_sort_based;

import graph.GraphAdjacencyListBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import static graph.EdgeType.WEIGHTED;
import static graph.GraphType.DIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathInADAGTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test(String input, int source, int[] expected) {
        var graphAdjacencyMatrixBuilder = new GraphAdjacencyListBuilder();
        ArrayList<ArrayList<Integer>> adjacencyList = graphAdjacencyMatrixBuilder.build(input, DIRECTED, WEIGHTED);
        Map<String, Integer> weights = graphAdjacencyMatrixBuilder.weights();
        var shortestPathInADAG = new ShortestPathInADAG();

        int[] paths = shortestPathInADAG.shortestPath(adjacencyList, source, weights);

        assertThat(paths).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "6 7\n" +
                                "0 1 2\n" +
                                "1 2 3\n" +
                                "2 3 6\n" +
                                "0 4 1\n" +
                                "4 2 2\n" +
                                "4 5 4\n" +
                                "5 3 1"
                        , 0,
                        new int[]{0, 2, 3, 6, 1, 5}),
                Arguments.of(
                        "6 7\n" +
                                "0 1 2\n" +
                                "1 2 3\n" +
                                "2 3 6\n" +
                                "0 4 1\n" +
                                "4 2 2\n" +
                                "4 5 4\n" +
                                "5 3 1"
                        , 1,
                        new int[]{Integer.MAX_VALUE, 0, 3, 9, Integer.MAX_VALUE, Integer.MAX_VALUE})
        );
    }


}