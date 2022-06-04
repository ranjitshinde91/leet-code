package stack.infix_to_prefix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class InfixToPrefix {
    private static final Map<Character, Integer> precedence = Map.of(
            '+', 0,
            '-', 0,
            '*', 1,
            '/', 1,
            '^', 2
    );
    private static final List<Character> parenthesis = List.of('(', ')');

    private static final Map<Character, Associativity> associativityMap = Map.of(
            '+', Associativity.LEFT_TO_RIGHT,
            '-', Associativity.LEFT_TO_RIGHT,
            '*', Associativity.LEFT_TO_RIGHT,
            '/', Associativity.LEFT_TO_RIGHT,
            '^', Associativity.RIGHT_TO_LEFT
    );


    public String convert(String infix) {

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = infix.length() - 1; i >= 0; i--) {
            Character character = infix.charAt(i);

            if (isOperand(character)) {
                prefix.append(character);
            } else if (')' == character) {
                stack.push(character);
            } else if ('(' == character) {
                while (')' != stack.peek()) {
                    prefix.append(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    stack.push(character);
                } else {
                    while (!stack.isEmpty() && !isParenthesis(stack.peek()) && shouldPopStackTopOperator(character, stack.peek())) {
                        prefix.append(stack.pop());
                    }
                    stack.push(character);
                }
            }
        }
        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }
        return prefix.reverse().toString();
    }

    private boolean shouldPopStackTopOperator(Character current, Character top) {
        return precedence.get(current) < precedence.get(top) ||
                (precedence.get(current) == precedence.get(top) && associativityMap.get(current) == Associativity.RIGHT_TO_LEFT);
    }

    private boolean isOperand(Character character) {
        return !precedence.containsKey(character) && !parenthesis.contains(character);

    }

    private boolean isParenthesis(Character character) {
        return parenthesis.contains(character);

    }
}

enum Associativity {
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT
}

