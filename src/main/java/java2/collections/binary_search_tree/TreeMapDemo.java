package java2.collections.binary_search_tree;

import java2.collections.Student;

import java.util.Comparator;
import java.util.TreeMap;


public class TreeMapDemo {

    public static void main(String[] args) {

        Student s1 = new Student(1, 10);
        Student s2 = new Student(2, 20);
        Student s3 = new Student(3, 5);
        Student s4 = new Student(4, 80);
        Student s5 = new Student(5, 50);


        System.out.println(" students by by");
        TreeMap<Student, Integer> studentById = new TreeMap<>(Comparator.comparingInt(Student::id));
        studentById.put(s1, s1.id());
        studentById.put(s2, s2.id());
        studentById.put(s3, s3.id());
        studentById.put(s4, s4.id());
        studentById.put(s5, s5.id());

        for (Student s : studentById.keySet()) {
            System.out.println(s);
        }

        System.out.println(".......");
        System.out.println(studentById.higherKey(s1));
        System.out.println(studentById.lowerKey(s2));

        System.out.println(" students by marks");
        TreeMap<Student, Integer> studentMarks = new TreeMap<>(Comparator.comparingInt(Student::marks).reversed());
        studentMarks.put(s1, s1.marks());
        studentMarks.put(s2, s2.marks());
        studentMarks.put(s3, s3.marks());
        studentMarks.put(s4, s4.marks());
        studentMarks.put(s5, s5.marks());

        for (Student s : studentMarks.keySet()) {
            System.out.println(s);
        }
    }
}


