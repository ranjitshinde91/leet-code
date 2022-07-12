package graph.detect_cycle_in_a_directed_graph;

import graph.GraphAdjacencyMatrixBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static graph.GraphType.DIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class DetectCycleInADirectedGraphTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void dfsBased(String input, boolean expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = GraphAdjacencyMatrixBuilder.build(input, DIRECTED);
        var detectCycleInADirectedGraph = new DetectCycleInADirectedGraph();

        boolean isCycle = detectCycleInADirectedGraph.isCycle(adjacencyList);

        assertThat(isCycle).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void bfsBased(String input, boolean expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = GraphAdjacencyMatrixBuilder.build(input, DIRECTED);
        var detectCycleInADirectedGraph = new DetectCycleInADirectedGraph();

        boolean isCycle = detectCycleInADirectedGraph.isCycleUsingKahnsAlgorithm(adjacencyList);

        assertThat(isCycle).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "11 11\n" +
                                "7 0\n" +
                                "0 4\n" +
                                "4 5\n" +
                                "5 6\n" +
                                "6 8\n" +
                                "8 9\n" +
                                "9 3\n" +
                                "3 2\n" +
                                "2 1\n" +
                                "1 10\n" +
                                "4 6"
                        , false),
                Arguments.of(
                        "4 4\n" +
                                "0 1\n" +
                                "1 2\n" +
                                "2 3\n" +
                                "3 3"
                        , true)
        );

    }
}