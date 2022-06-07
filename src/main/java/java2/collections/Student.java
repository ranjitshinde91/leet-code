package java2.collections;

public class Student {
    private final int id;
    private final int marks;

    public Student(int id, int marks) {
        this.id = id;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", marks=" + marks +
                '}';
    }

    public int id() {
        return id;
    }

    public int marks() {
        return marks;
    }
}
