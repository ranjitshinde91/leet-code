package graph.minimum_spanning_tree.kruskals_algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KruskalAlgorithmTest {

    @ParameterizedTest
    @MethodSource("input")
    void disjointSetBased(List<Edge> edges, int v, int expected) {

        var kruskalAlgorithm = new KruskalAlgorithm();

        int cost = kruskalAlgorithm.minimumSpanningTreeCost(edges, v);

        assertThat(cost).isEqualTo(expected);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Edge(1, 2, 4),
                                new Edge(1, 3, 3),
                                new Edge(2, 4, 1),
                                new Edge(2, 5, 1),
                                new Edge(4, 5, 3),
                                new Edge(3, 4, 2)
                        ),
                        5,
                        7
                ),
                Arguments.of(
                        List.of(
                                new Edge(1, 2, 5),
                                new Edge(2, 3, 6),
                                new Edge(1, 4, 7),
                                new Edge(2, 4, 8),
                                new Edge(3, 4, 7)
                        ),
                        4,
                        18
                ),
                Arguments.of(
                        List.of(
                                new Edge(1, 2, 8),
                                new Edge(1, 5, 14),
                                new Edge(1, 8, 19),
                                new Edge(2, 3, 14),
                                new Edge(2, 5, 4),
                                new Edge(2, 6, 17),
                                new Edge(2, 7, 7),
                                new Edge(2, 8, 15),
                                new Edge(3, 7, 6),
                                new Edge(3, 8, 10),
                                new Edge(3, 9, 12),
                                new Edge(4, 7, 13),
                                new Edge(4, 8, 18),
                                new Edge(4, 9, 3),
                                new Edge(6, 7, 17),
                                new Edge(6, 8, 10)
                        ),
                        9,
                        60
                )
















        );
    }
}