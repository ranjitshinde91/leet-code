package stack.prefix_evaluation;

import java.util.ArrayDeque;
import java.util.List;

public class PrefixEvaluation {
    private static List<String> operators = List.of("+", "-", "*", "/", "^");


    public long evaluate(String prefix) {
        String[] expression = prefix.split(" ");
        ArrayDeque<String> stacks = new ArrayDeque<>();

        for (int i = expression.length - 1; i >= 0; i--) {
            String s = expression[i];
            if (!isOperator(s)) {
                stacks.push(s);
            } else {
                String pop1 = stacks.pop();
                String pop2 = stacks.pop();
                Double evaluate = evaluate(Double.valueOf(pop1), Double.valueOf(pop2), s);
                stacks.push(String.valueOf(evaluate));
            }
        }
        Double v = Double.parseDouble(stacks.pop());
        return v.longValue();
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

    private boolean isOperator(String character) {
        return operators.contains(character);
    }
}
