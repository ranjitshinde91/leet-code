package stack.next_greater_element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NextGreaterElementTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, long[] expected) {
        Solution solution = new Solution();

        long[] span = solution.nextLargerElement(input, input.length);

        assertThat(span).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{1, 3, 2, 4}, new long[]{3, 4, 4, -1}),
                Arguments.of(new long[]{6, 8, 0, 1, 3}, new long[]{8, -1, 1, 3, -1})
        );
    }
}