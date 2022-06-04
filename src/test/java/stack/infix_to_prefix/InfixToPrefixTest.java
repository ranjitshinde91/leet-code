package stack.infix_to_prefix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InfixToPrefixTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String infix, String expected) {
        var infixToPrefix = new InfixToPrefix();

        String postfix = infixToPrefix.convert(infix);

        assertThat(postfix).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("a+b-c", "-+abc"),
                Arguments.of("a+b-c+d", "+-+abcd"),
                Arguments.of("a+b*c", "+a*bc"),
                Arguments.of("(a+b)*c", "*+abc"),
                Arguments.of("a^b^c", "^a^bc")
        );
    }


}