package stack.evaluate_reverse_polish_notation;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class EvaluateReversePolishNotationTest {

  @Test
  void test() {
    var evaluateReversePolishNotation = new EvaluateReversePolishNotation();

    int result =
        evaluateReversePolishNotation.evalRPN(
            new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});

    assertThat(result).isEqualTo(22);
  }
}
