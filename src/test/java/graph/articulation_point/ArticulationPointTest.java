package graph.articulation_point;

import graph.GraphAdjacencyListBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static graph.GraphType.UNDIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class ArticulationPointTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void dfsBased(String input, List<Integer> articulationPoints) {
        ArrayList<ArrayList<Integer>> adjacencyList = new GraphAdjacencyListBuilder().build(input, UNDIRECTED);
        var articulationPoint = new ArticulationPoint();

        ArrayList<Integer> output = articulationPoint.articulationPoints(adjacencyList.size(), adjacencyList);

        assertThat(output).containsExactlyInAnyOrderElementsOf(articulationPoints);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "5 5\n" +
                                "0 1\n" +
                                "1 4\n" +
                                "4 3\n" +
                                "3 2\n" +
                                "2 4"
                        , List.of(1, 4))
        );

    }
}