package stack.next_greater_element;

import java.util.Stack;

class Solution {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] nextLargerNumbers = new long[n];
        Stack<Integer> greaterElements = new Stack<>();

        greaterElements.push(n - 1);
        nextLargerNumbers[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            while (!greaterElements.isEmpty() && arr[i] > arr[greaterElements.peek()]) {
                greaterElements.pop();
            }
            if (greaterElements.isEmpty()) {
                nextLargerNumbers[i] = -1;
            } else {
                nextLargerNumbers[i] = arr[greaterElements.peek()];
            }
            greaterElements.push(i);

        }
        return nextLargerNumbers;
    }
}