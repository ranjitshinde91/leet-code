package stack.infix_to_postfix;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InfixToPostfix {

    private static Map<Character, Integer> operators = Map.of(
            '+', 0,
            '-', 0,
            '*', 1,
            '/', 1,
            '^', 2);
    private static final List<Character> parenthesis = List.of('(', ')');

    public String convert(String infix) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isOperand(c)) {
                stringBuilder.append(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && '(' != stack.peek()) {
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                } else if (isOperator(c)) {
                    if (stack.isEmpty() || !isOperator(stack.peek())) {
                        stack.push(c);
                    } else {
                        Character pop = stack.peek();
                        if (isHigherPrecedenceThanStackTop(c, pop)) {
                            stack.push(c);
                        } else if (isLowerPrecedenceThanStackTop(c, pop)) {
                            while (!stack.isEmpty() && isHigherPrecedenceThanStackTop(c, stack.peek())) {
                                stringBuilder.append(stack.pop());
                            }
                            stack.push(c);
                        } else if (isEqualPrecedenceThanStackTop(c, pop)) {
                            stack.push(c);
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

    private boolean isEqualPrecedenceThanStackTop(Character c, Character pop) {
        return Objects.equals(operators.get(c), operators.get(pop));
    }

    private boolean isLowerPrecedenceThanStackTop(Character c, Character pop) {
        return operators.get(c) < operators.get(pop);
    }

    private boolean isHigherPrecedenceThanStackTop(Character c, Character pop) {
        return operators.get(c) > operators.get(pop);
    }

    private boolean isOperator(char c) {
        return operators.containsKey(c);
    }

    private boolean isOperand(char c) {
        return !operators.containsKey(c) && !parenthesis.contains(c);
    }
}
