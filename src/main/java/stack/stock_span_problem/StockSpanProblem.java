package stack.stock_span_problem;

import java.util.Stack;

class Solution {
    //Function to calculate the span of stock price for all n days.
    public static int[] calculateSpan1(int price[], int n) {
        int[] ints = new int[n];
        ints[0] = 1;

        for (int i = 1; i < price.length; i++) {
            int span = 1;
            int k = i - 1;
            while (k >= 0 && price[k] <= price[i]) {
                span++;
                k--;
            }
            ints[i] = span;
        }
        return ints;
    }

    public static int[] calculateSpan(int price[], int n) {
        int[] ints = new int[n];

        Stack<Integer> previousGreater = new Stack<>();
        previousGreater.push(0);
        ints[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!previousGreater.isEmpty() && price[previousGreater.peek()] <= price[i]) {
                previousGreater.pop();
            }
            if (previousGreater.isEmpty()) {
                ints[i] = i + 1;
            } else {
                ints[i] = i - previousGreater.peek();
            }
            previousGreater.push(i);
        }
        return ints;
    }
}
