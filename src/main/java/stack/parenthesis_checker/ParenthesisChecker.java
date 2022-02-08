package stack.parenthesis_checker;

import java.util.Map;
import java.util.Stack;


class Solution {
    //Function to check if brackets are balanced or not.

    static Map<Character, Character> paranthesisPair = Map.of(
            '}', '{',
            ')', '(',
            ']', '[');

    static boolean ispar(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!paranthesisPair.containsKey(character)) {
                stack.push(character);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character poppedChar = stack.pop();
                if (poppedChar != paranthesisPair.get(character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
