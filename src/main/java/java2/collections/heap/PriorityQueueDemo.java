package java2.collections.heap;

import java2.collections.Student;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        Student s1 = new Student(1, 50);
        Student s2 = new Student(1, 90);

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Student::id));

        priorityQueue.add(s2);
        priorityQueue.add(s1);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());


    }
}




