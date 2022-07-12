package graph.detect_cycle_in_an_undirected_graph;

import graph.GraphAdjacencyMatrixBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static graph.GraphType.UNDIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class DetectCycleInAnUndirectedGraphTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void name(String input, boolean expected) {
        var adjacencyList = GraphAdjacencyMatrixBuilder.build(input, UNDIRECTED);
        var detectCycleInAnUndirectedGraph = new DetectCycleInAnUndirectedGraph();

        boolean isCycle = detectCycleInAnUndirectedGraph.isCycle( adjacencyList);

        assertThat(isCycle).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "5 5\n" +
                                "1 0\n" +
                                "1 2\n" +
                                "1 4\n" +
                                "2 3\n" +
                                "3 4"
                        , true),
                Arguments.of(
                        "4 2\n" +
                                "1 2\n" +
                                "2 3"
                        , false)
        );

    }

}