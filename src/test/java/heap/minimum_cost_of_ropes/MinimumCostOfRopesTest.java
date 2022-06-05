package heap.minimum_cost_of_ropes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCostOfRopesTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, long expected) {
        MinimumCostOfRopes minimumCostOfRopes = new MinimumCostOfRopes();

        long cost = minimumCostOfRopes.minCost(input, input.length);

        assertThat(cost).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{4, 3, 2, 6}, 29),
                Arguments.of(new long[]{4, 2, 7, 6, 9}, 62)
        );
    }

}