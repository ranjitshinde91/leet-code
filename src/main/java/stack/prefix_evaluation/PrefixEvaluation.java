package stack.prefix_evaluation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PrefixEvaluation {
    private static final List<String> operators = List.of("+", "-", "*", "/", "^");


    public long evaluate(String prefix){

        String[] expression = prefix.split(" ");
        Deque<Double> stack = new ArrayDeque();

        for(int i=expression.length-1;i>=0;i--){

            String element = expression[i];

            if(isOperand(element)){
                stack.push(Double.valueOf(element));
            }else{
                Double second = stack.pop();
                Double first = stack.pop();
                stack.push(evaluate(element, second, first));
            }
        }

        return stack.pop().longValue();

    }

    private boolean isOperand(String element) {
        return !operators.contains(element);
    }

    private Double evaluate(String operator, Double first, Double second){

        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            case "^" -> Math.pow(first, second);
            default -> 0.0;
        };
    }
}
