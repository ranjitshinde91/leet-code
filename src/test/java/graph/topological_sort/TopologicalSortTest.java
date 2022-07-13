package graph.topological_sort;

import graph.GraphAdjacencyMatrixBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static graph.GraphType.DIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class TopologicalSortTest {

    @ParameterizedTest
    @MethodSource("bfsBased")
    void bfsBased(String input, int[] expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = GraphAdjacencyMatrixBuilder.build(input, DIRECTED);
        var topologicalSort = new TopologicalSort();

        int[] paths = topologicalSort.bfsBased(adjacencyList.size(), adjacencyList);

        assertThat(paths).containsExactly(expected);
    }

    private static Stream<Arguments> bfsBased() {
        return Stream.of(
                Arguments.of(
                        "5 5\n" +
                                "0 2\n" +
                                "0 3\n" +
                                "2 3\n" +
                                "1 3\n" +
                                "1 4"
                        , new int[]{0, 1, 2, 4, 3}),
                Arguments.of(
                        "4 3\n" +
                                "3 0\n" +
                                "1 0\n" +
                                "2 0"
                        , new int[]{1, 2, 3, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("dfsBased")
    void dfsBased(String input, int[] expected) {
        ArrayList<ArrayList<Integer>> adjacencyList = GraphAdjacencyMatrixBuilder.build(input, DIRECTED);
        var topologicalSort = new TopologicalSort();

        int[] paths = topologicalSort.dfsBased(adjacencyList.size(), adjacencyList);

        assertThat(paths).containsExactly(expected);
    }

    private static Stream<Arguments> dfsBased() {
        return Stream.of(
                Arguments.of(
                        "5 5\n" +
                                "0 2\n" +
                                "0 3\n" +
                                "2 3\n" +
                                "1 3\n" +
                                "1 4"
                        , new int[]{1, 4, 0, 2, 3}),
                Arguments.of(
                        "4 3\n" +
                                "3 0\n" +
                                "1 0\n" +
                                "2 0"
                        , new int[]{3, 2, 1, 0})

        );
    }


}