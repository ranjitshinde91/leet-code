package stack.postfix_evaluation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PostFixEvaluationTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String postfix, long expected) {
        var postFixEvaluation = new PostFixEvaluation();

        long output = postFixEvaluation.evaluate(postfix);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("10 2 * 3 +", 23),
                Arguments.of("10 2 + 3 *", 36),
                Arguments.of("10 2 3 ^ ^", 1_0000_0000),
                Arguments.of("10 3 2 + /", 2)
        );
    }

}