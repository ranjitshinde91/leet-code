package java2.collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
    }
}
