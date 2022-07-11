package binary_search_tree.bottom_view_of_binary_tree;

import tree.Node;

import java.util.*;

public class BottomViewOfBinaryTree {

    public ArrayList<Integer> view(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node, 0));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            Node curr = poll.node;
            int hd = poll.hd;

            if (map.containsKey(hd)) {
                map.computeIfPresent(hd, (key, old) -> curr.data);
            } else {
                map.put(hd, curr.data);
            }

            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }
}

class Pair {
    Node node;
    int hd;

    public Pair(Node node, int hd) {

        this.node = node;
        this.hd = hd;
    }
}