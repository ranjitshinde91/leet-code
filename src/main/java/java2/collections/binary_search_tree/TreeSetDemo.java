package java2.collections.binary_search_tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>();
        new HashSet<>();
        new LinkedHashSet<>();

        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("C");

        System.out.println(treeSet);
        System.out.println(treeSet.contains("C"));
        System.out.println(treeSet.contains("C"));
        System.out.println(treeSet.floor("F"));

        treeSet.add("D");
        treeSet.add("E");

        treeSet.remove("A");

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
