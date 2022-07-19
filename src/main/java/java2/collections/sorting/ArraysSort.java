package java2.collections.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {


        int[] numbers = new int[]{5, 4, 1, 2, 7};

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        Integer[] numbersObjects = new Integer[]{5, 4, 1, 2, 7};

        Arrays.sort(numbersObjects, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbersObjects));

        Point[] points = new Point[]{
                new Point(0, 0),
                new Point(2, 2),
                new Point(1, 1),
        };

        Arrays.sort(points, Comparator.comparingInt(it -> it.x));
        System.out.println(Arrays.toString(points));

        Arrays.sort(points, Collections.reverseOrder(Comparator.comparingInt(it -> it.y)));
        System.out.println(Arrays.toString(points));
    }
}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}