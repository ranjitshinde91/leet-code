package other.combination_sum_4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumIVTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test(int[] input, int target, int expected) {
        var solution = new Solution();

        int numberOfPossibleCombinations = solution.combinationSum4(input, target);

        assertThat(numberOfPossibleCombinations).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{9}, 3, 0),
                Arguments.of(new int[]{3, 4}, 2, 0),
                Arguments.of(new int[]{1, 2}, 3, 3),
                Arguments.of(new int[]{1, 2, 3}, 4, 7),
                Arguments.of(new int[]{2, 1, 3}, 35, 1132436852)
        );
    }
}