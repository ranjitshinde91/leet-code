package stack.evaluate_reverse_polish_notation;

import java.util.ArrayDeque;
import java.util.List;

// leetcode-150: Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < tokens.length; i++) {
      String character = tokens[i];

      if (!List.of("+", "-", "*", "/").contains(character)) {
        stack.push(Integer.valueOf(character));
      } else {
        int first = stack.pop();
        int second = stack.pop();

        if (character.equals("+")) {
          stack.push(second + first);
        } else if (character.equals("-")) {
          stack.push(second - first);
        } else if (character.equals("*")) {
          stack.push(second * first);
        } else {
          stack.push(second / first);
        }
      }
    }
    return stack.peek();
  }
}
