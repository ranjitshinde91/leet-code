package stack.largest_rectangular_area;

import stack.previous_greater_element.PreviousGreaterElement;

import java.util.ArrayDeque;

public class LargestRectangularArea {

    public long calculateArea1(long[] input) {
        long max = 0;

        for (int i = 0; i < input.length; i++) {
            long area = input[i];

            int j = i - 1;
            while (j >= 0 && input[j] >= input[i]) {
                area = area + input[i];
                j--;
            }
            int k = i + 1;
            while (k < input.length && input[k] >= input[i]) {
                area = area + input[i];
                k++;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    public long calculateArea(long[] input) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
                Integer tp = stack.pop();
                long curr = input[tp] * (stack.isEmpty() ? 1 : (i - stack.peek() - 1));
                if (curr > sum) {
                    sum = curr;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer tp = stack.pop();
            long curr = input[tp] * (stack.isEmpty() ? input.length : (input.length - stack.peek() - 1));
            if (curr > sum) {
                sum = curr;
            }
        }
        return sum;
    }
}