package java2.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(5);
        list.add(20);

        Collections.sort(list);

        System.out.println(list);

        list.sort(Collections.reverseOrder());

        System.out.println(list);

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(0, 1));
        points.add(new Point(1, 2));

        points.sort(Comparator.comparingInt(it -> it.x));
        System.out.println(points);

    }
}