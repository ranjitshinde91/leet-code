package stack.infix_to_postfix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InfixToPostfixTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String infix, String expected) {
        var infixToPostfix = new InfixToPostfix();

        String postfix = infixToPostfix.convert(infix);

        assertThat(postfix).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("a+b*c", "abc*+"),
                Arguments.of("(a+b)*c", "ab+c*"),
                Arguments.of("a^b^c", "abc^^"),
                Arguments.of("(a+b)*(c+d)", "ab+cd+*")
        );
    }

}