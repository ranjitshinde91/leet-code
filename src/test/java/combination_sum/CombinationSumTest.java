package combination_sum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test(int[] input, int target, List<List<Integer>> expected) {
        var solution = new Solution();

        var uniqueCombinations = solution.combinationSum(input, target);


        for (var combination : uniqueCombinations) {
            Collections.sort(combination);
        }
        assertThat(uniqueCombinations).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5}, 3, List.of(List.of(1, 1, 1), List.of(1, 2))),
                Arguments.of(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
                Arguments.of(new int[]{2, 3, 5}, 8, List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)))
        );
    }

    @Test
    void test2() {
        var solution = new Solution();

        var uniqueCombinations = solution.combinationSum(new int[]{2}, 1);

        assertThat(uniqueCombinations).isEmpty();
    }

}