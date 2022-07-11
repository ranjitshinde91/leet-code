package binary_search_tree.vertical_sum_in_a_tree;

import tree.Node;

import java.util.*;

public class VerticalSumInATree {

    public List<Integer> sum(Node node) {
        Map<Integer, Integer> map = new TreeMap<>();
        _sum(node, 0, map);
        return new ArrayList<>(map.values());
    }

    private void _sum(Node node, int level, Map<Integer, Integer> map) {
        if (node != null) {
            _sum(node.left, level - 1, map);
            if (!map.containsKey(level)) {
                map.computeIfAbsent(level, key -> node.data);
            } else {
                map.computeIfPresent(level, (key, value) -> value + node.data);
            }
            _sum(node.right, level + 1, map);
        }
    }
}
