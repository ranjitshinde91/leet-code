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
                Arguments.of(new int[]{1, 2}, 4, List.of(List.of(1, 1, 1, 1), List.of(1, 1, 2), List.of(2, 2))),
                Arguments.of(new int[]{1, 2, 5}, 3, List.of(List.of(1, 1, 1), List.of(1, 2))),
                Arguments.of(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
                Arguments.of(new int[]{2, 3, 5}, 8, List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
                Arguments.of(new int[]{1}, 9, List.of(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1))),
                Arguments.of(new int[]{2, 7, 6, 3, 5, 1}, 9, List.of(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(1, 1, 1, 1, 1, 1, 1, 2), List.of(1, 1, 1, 1, 1, 1, 3), List.of(1, 1, 1, 1, 1, 2, 2), List.of(1, 1, 1, 1, 2, 3), List.of(1, 1, 1, 1, 5), List.of(1, 1, 1, 2, 2, 2), List.of(1, 1, 1, 3, 3), List.of(1, 1, 1, 6), List.of(1, 1, 2, 2, 3), List.of(1, 1, 2, 5), List.of(1, 1, 7), List.of(1, 2, 2, 2, 2), List.of(1, 2, 3, 3), List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 2, 2, 3), List.of(2, 2, 5), List.of(2, 7), List.of(3, 3, 3), List.of(3, 6)))
//                Arguments.of(new int[]{5, 10, 8, 4, 3, 12, 9}, 27, List.of(List.of(3, 3, 3, 3, 3, 3, 3, 3, 3), List.of(3, 3, 3, 3, 3, 3, 4, 5), List.of(3, 3, 3, 3, 3, 3, 9), List.of(3, 3, 3, 3, 3, 4, 4, 4), List.of(3, 3, 3, 3, 3, 4, 8), List.of(3, 3, 3, 3, 3, 12), List.of(3, 3, 3, 3, 5, 5, 5), List.of(3, 3, 3, 3, 5, 10), List.of(3, 3, 3, 4, 4, 5, 5), List.of(3, 3, 3, 4, 4, 10), List.of(3, 3, 3, 4, 5, 9), List.of(3, 3, 3, 5, 5, 8), List.of(3, 3, 3, 8, 10), List.of(3, 3, 3, 9, 9), List.of(3, 3, 4, 4, 4, 4, 5), List.of(3, 3, 4, 4, 4, 9), List.of(3, 3, 4, 4, 5, 8), List.of(3, 3, 4, 5, 12), List.of(3, 3, 4, 8, 9), List.of(3, 3, 5, 8, 8), List.of(3, 3, 9, 12), List.of(3, 4, 4, 4, 4, 4, 4), List.of(3, 4, 4, 4, 4, 8), List.of(3, 4, 4, 4, 12), List.of(3, 4, 4, 8, 8), List.of(3, 4, 5, 5, 5, 5), List.of(3, 4, 5, 5, 10), List.of(3, 4, 8, 12), List.of(3, 4, 10, 10), List.of(3, 5, 5, 5, 9), List.of(3, 5, 9, 10), List.of(3, 8, 8, 8), List.of(3, 12, 12), List.of(4, 4, 4, 5, 5, 5), List.of(4, 4, 4, 5, 10), List.of(4, 4, 5, 5, 9), List.of(4, 4, 9, 10), List.of(4, 5, 5, 5, 8), List.of(4, 5, 8, 10), List.of(4, 5, 9, 9), List.of(5, 5, 5, 12), List.of(5, 5, 8, 9), List.of(5, 10, 12), List.of(8, 9, 10), List.of(9, 9, 9)))
        );
    }


    @Test
    void test2() {
        var solution = new Solution();

        var uniqueCombinations = solution.combinationSum(new int[]{2}, 1);

        assertThat(uniqueCombinations).isEmpty();
    }

}