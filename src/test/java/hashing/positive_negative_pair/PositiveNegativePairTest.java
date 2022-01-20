package hashing.positive_negative_pair;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveNegativePairTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input1, List<Integer> expected) {

        Solution solution = new Solution();

        var pairs = solution.findPairs(input1, input1.length);

        assertThat(pairs).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, -2, -1, -3, 2, 7}, List.of(1, -1, 3, -3, -2, 2)),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, List.of()),
                Arguments.of(new int[]{1, -1}, List.of(1, -1))
        );
    }

}