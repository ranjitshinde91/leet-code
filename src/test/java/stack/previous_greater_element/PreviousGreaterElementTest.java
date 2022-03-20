package stack.previous_greater_element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PreviousGreaterElementTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, long[] expected) {
        var previousGreaterElement = new PreviousGreaterElement();

        long[] span = previousGreaterElement.calculate(input, input.length);

        assertThat(span).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{15, 10, 18, 12, 4, 6, 2, 8}, new long[]{-1, 15, -1, 18, 12, 12, 6, 12}),
                Arguments.of(new long[]{8, 10, 12}, new long[]{-1, -1, -1}),
                Arguments.of(new long[]{12, 10, 8}, new long[]{-1, 12, 10})
        );
    }
}