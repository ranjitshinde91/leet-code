package searching.subarray_with_given_sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubarrayWithGivenSumTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int sum, List<Integer> expectedIndices) {

        Solution solution = new Solution();

        List<Integer> indices = solution.subarraySum(input, sum);

        assertThat(indices).containsExactlyElementsOf(expectedIndices);

    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 7, 5}, 12, List.of(2, 4)),
                Arguments.of(new int[]{1, 2, 3, 7, 5}, 20, List.of(-1)),
                Arguments.of(new int[]{1, 2, 3, 7, 5}, 5, List.of(2, 3)),
                Arguments.of(new int[]{1, 2, 3, 7, 5}, 7, List.of(4, 4)),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15, List.of(1, 5))
        );
    }

}