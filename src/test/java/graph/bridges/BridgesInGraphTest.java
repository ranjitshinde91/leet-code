package graph.bridges;

import graph.GraphAdjacencyListBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static graph.GraphType.UNDIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class BridgesInGraphTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void dfsBased(String input, List<Edge> articulationPoints) {
        ArrayList<ArrayList<Integer>> adjacencyList = new GraphAdjacencyListBuilder().build(input, UNDIRECTED);
        var bridgesInGraph = new BridgesInGraph();

        ArrayList<Edge> output = bridgesInGraph.bridges(adjacencyList.size(), adjacencyList);

        assertThat(output).containsExactlyInAnyOrderElementsOf(articulationPoints);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "4 3\n" +
                                "0 1\n" +
                                "1 2\n" +
                                "2 3"
                        , List.of(
                                new Edge(0, 1),
                                new Edge(1, 2),
                                new Edge(2, 3)
                        ))
        );

    }

}