package stack.prefix_evaluation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrefixEvaluationTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String prefix, long expected) {
        var prefixEvaluation = new PrefixEvaluation();

        long output = prefixEvaluation.evaluate(prefix);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("+ * 10 2 3", 23),
                Arguments.of("* + 10 2 3", 36),
                Arguments.of("+ * / 50 10 3 3", 18),
                Arguments.of("^ 10 ^ 2 3", 1_0000_0000)
        );
    }


}