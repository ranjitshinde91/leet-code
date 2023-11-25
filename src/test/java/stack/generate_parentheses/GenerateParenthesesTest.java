package stack.generate_parentheses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GenerateParenthesesTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int input, List<String> expected) {
    var generateParenthesis = new GenerateParentheses();

    List<String> strings = generateParenthesis.generateParenthesis(input);

    assertThat(strings).containsExactlyInAnyOrderElementsOf(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
        Arguments.of(1, List.of("()")));
  }
}
