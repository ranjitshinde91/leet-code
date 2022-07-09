package binary_search_tree.ceiling_on_left_side;

import java.util.Objects;
import java.util.TreeSet;

public class CeilingOnLeftSide {

    public int[] ceil(int[] ints) {
        int[] ceil = new int[ints.length];
        ceil[0] = -1;
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(ints[0]);

        for (int i = 1; i < ints.length; i++) {
            Integer ceiling = integers.ceiling(ints[i]);
            ceil[i] = Objects.requireNonNullElse(ceiling, -1);
            integers.add(ints[i]);
        }
        return ceil;
    }
}
