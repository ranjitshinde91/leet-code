package binary_search_tree.vertical_traversal_of_binary_tree;

import tree.Node;

import java.util.*;

public class VerticalTraversalOfABST {

    public ArrayList<Integer> traverse(Node node) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node, 0));
        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.horizontalDistance;

            if (map.containsKey(hd)) {
                map.get(hd).add(curr.data);
            } else {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(curr.data);
                map.put(hd, objects);
            }
            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        map.values().forEach(list::addAll);
        return list;
    }

}

class Pair{

    Node node;
    int horizontalDistance;

    public Pair(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
