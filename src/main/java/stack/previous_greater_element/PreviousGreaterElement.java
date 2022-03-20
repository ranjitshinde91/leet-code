package stack.previous_greater_element;

import java.util.ArrayDeque;

public class PreviousGreaterElement {


    public long[] calculate(long[] input, int length) {

        ArrayDeque<Long> previousGreater = new ArrayDeque<>();
        long[] previousGreaterElements = new long[length];

        previousGreater.push(input[0]);
        previousGreaterElements[0] = -1;

        for (int i = 1; i < input.length; i++) {
            while (!previousGreater.isEmpty() && previousGreater.peek() <= input[i]) {
                previousGreater.pop();
            }
            if (previousGreater.isEmpty()) {
                previousGreaterElements[i] = -1;
            } else {
                previousGreaterElements[i] = previousGreater.peek();
            }
            previousGreater.push(input[i]);
        }
        return previousGreaterElements;
    }
}
