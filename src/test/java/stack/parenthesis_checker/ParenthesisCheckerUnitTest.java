package stack.parenthesis_checker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParenthesisCheckerUnitTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String input, boolean expected) {

        Solution solution = new Solution();

        boolean ispar = solution.ispar(input);

        assertThat(ispar).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("]", false),
                Arguments.of("{([])}", true),
                Arguments.of("()", true),
                Arguments.of("([]", false)
        );
    }

}