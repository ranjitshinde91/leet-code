package stack.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

// leetcode-22: Generate Parentheses
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {

    return _generateParenthesis("", 0, 0, n);
  }

  private List<String> _generateParenthesis(String string, int open, int closed, int total) {
    if (open == total && closed == total) {
      return List.of(string);
    }
    ArrayList<String> parenthesis = new ArrayList<>();
    if (open < total) {
      parenthesis.addAll(_generateParenthesis(string + "(", open + 1, closed, total));
    }
    if (closed < open) {
      parenthesis.addAll(_generateParenthesis(string + ")", open, closed + 1, total));
    }
    return parenthesis;
  }
}
