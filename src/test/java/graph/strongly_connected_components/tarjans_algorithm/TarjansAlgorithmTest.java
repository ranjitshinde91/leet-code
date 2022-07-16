package graph.strongly_connected_components.tarjans_algorithm;

import graph.GraphAdjacencyListBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static graph.EdgeType.UNWEIGHTED;
import static graph.GraphType.DIRECTED;
import static org.assertj.core.api.Assertions.assertThat;

class TarjansAlgorithmTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test(String input, ArrayList<ArrayList<Integer>> expected) {
        var graphAdjacencyMatrixBuilder = new GraphAdjacencyListBuilder();
        var adjacencyList = graphAdjacencyMatrixBuilder.build(input, DIRECTED, UNWEIGHTED);

        var tarjansAlgorithm = new TarjansAlgorithm();

        var stronglyConnectedComponents = tarjansAlgorithm.stronglyConnectedComponents(adjacencyList.size(), adjacencyList);

        for (int i = 0; i < expected.size(); i++) {
            assertThat(stronglyConnectedComponents.get(i)).containsExactlyElementsOf(expected.get(i));
        }
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        "5 5\n" +
                                "1 0\n" +
                                "0 2\n" +
                                "2 1\n" +
                                "0 3\n" +
                                "3 4"
                        ,
                        new ArrayList<>(
                                List.of(
                                        new ArrayList<>(List.of(0, 1, 2)),
                                        new ArrayList<>(List.of(3)),
                                        new ArrayList<>(List.of(4)
                                        )
                                ))
                ),
                Arguments.of(
                        "8 13\n" +
                                "4 4\n" +
                                "3 1\n" +
                                "0 2\n" +
                                "6 3\n" +
                                "6 5\n" +
                                "1 4\n" +
                                "1 7\n" +
                                "3 7\n" +
                                "1 0\n" +
                                "3 3\n" +
                                "4 3\n" +
                                "1 4\n" +
                                "7 6",
                        new ArrayList<>(
                                List.of(
                                        new ArrayList<>(List.of(0)),
                                        new ArrayList<>(List.of(1, 3, 4, 6, 7)),
                                        new ArrayList<>(List.of(2)),
                                        new ArrayList<>(List.of(5)
                                        )
                                ))
                )


        );
    }
}