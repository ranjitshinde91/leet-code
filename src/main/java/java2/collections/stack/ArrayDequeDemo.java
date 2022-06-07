package java2.collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {


    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);


        System.out.println(stack.size());
        System.out.println(stack.peek());

        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.remove());
        System.out.println(stack.isEmpty());
    }
}
