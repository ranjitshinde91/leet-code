package stack.postfix_evaluation;

import java.util.List;
import java.util.Stack;

public class PostFixEvaluation {
    private static List<String> operators = List.of("+", "-", "*", "/", "^");

    public long evaluate(String postfix) {
        String[] expression = postfix.split(" ");
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            String s = expression[i];
            if (isOperand(s)) {
                stack.push(Double.valueOf(s));
            } else {
                Double second = stack.pop();
                Double first = stack.pop();
                Double value1 = evaluate(first, second, s);
                stack.push(value1);
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
