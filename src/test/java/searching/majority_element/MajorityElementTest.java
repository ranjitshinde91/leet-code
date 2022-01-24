package searching.majority_element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int expected) {

        Solution solution = new Solution();

        long floorSqrt = solution.findMajorityElement(input);

        assertThat(floorSqrt).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{3, 1, 3, 3, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 3, 3}, 3),
                Arguments.of(new int[]{1, 3, 3, 3, 2}, 3),
                Arguments.of(new int[]{3, 3, 3, 2, 1}, 3)
        );
    }

}