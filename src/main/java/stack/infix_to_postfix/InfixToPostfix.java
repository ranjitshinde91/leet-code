package stack.infix_to_postfix;

import java.util.List;
import java.util.Map;
import java.util.Stack;


public class InfixToPostfix {
    private final Map<Character, Integer> operators =
            Map.of(
                    '+', 0,
                    '-', 0,
                    '*', 1,
                    '/', 1,
                    '^', 2);
    private static final List<Character> parenthesis = List.of('(', ')');

    private final Map<Character, Associativity> associativityMap =
            Map.of(
                    '+', Associativity.LEFT_T0_RIGHT,
                    '-', Associativity.LEFT_T0_RIGHT,
                    '*', Associativity.LEFT_T0_RIGHT,
                    '/', Associativity.LEFT_T0_RIGHT,
                    '^', Associativity.RIGHT_TO_LEFT
            );

    public String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postFix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            Character character = infix.charAt(i);
            if (isOperand(character)) {
                postFix.append(character);
            } else if ('(' == character) {
                stack.push(character);
            } else if (')' == character) {
                while ('(' != stack.peek()) {
                    postFix.append(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty() || parenthesis(stack.peek())) {
                    stack.push(character);
                } else {
                    while (!stack.isEmpty() && shouldPopOperator(character, stack.peek())) {
                        postFix.append(stack.pop());
                    }
                    stack.push(character);
                }
            }
        }
        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    private boolean shouldPopOperator(Character character, Character top) {
        return isLowerPrecedenceThanStackTop(character, top) ||
                (isEqualPrecedenceToStackTop(character, top) && associativityMap.get(character) == Associativity.LEFT_T0_RIGHT);
    }

    private boolean parenthesis(Character character) {
        return parenthesis.contains(character);
    }

    private boolean isLowerPrecedenceThanStackTop(Character current, Character top) {
        return operators.get(current) < operators.get(top);
    }

    private boolean isHigherPrecedenceThanStackTop(Character current, Character top) {
        return operators.get(current) > operators.get(top);
    }

    private boolean isEqualPrecedenceToStackTop(Character current, Character top) {
        return (operators.get(current) == operators.get(top));
    }

    private boolean isOperand(Character character) {
        return !operators.containsKey(character) && !parenthesis.contains(character);
    }
}

enum Associativity {
    LEFT_T0_RIGHT,
    RIGHT_TO_LEFT
}
