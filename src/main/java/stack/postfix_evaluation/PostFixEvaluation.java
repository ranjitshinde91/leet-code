package stack.postfix_evaluation;

import java.util.List;
import java.util.Stack;

public class PostFixEvaluation {
    private static final List<String> operators = List.of("+", "-", "*", "/", "^");

    public long evaluate(String postfix) {
        String[] expression = postfix.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String character : expression) {
            if (isOperand(character)) {
                stack.push(Double.valueOf(character));
            } else {
                Double second = stack.pop();
                Double first = stack.pop();
                stack.push(evaluate(first, second, character));
            }
        }
        return stack.pop().longValue();
    }

    private Double evaluate(Double first, Double second, String s) {
        switch (s) {
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "^":
                return Math.pow(first, second);
            case "+":
                return first + second;
            case "-":
                return first - second;
        }
        throw new RuntimeException();
    }

    private boolean isOperand(String character) {
        return !operators.contains(character);
    }
}
