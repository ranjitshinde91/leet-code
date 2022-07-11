package graph.depth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DepthFirstTraversal {

    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);


        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (!list.contains(temp)) {
                list.add(temp);
            }
            ArrayList<Integer> nodes = adj.get(temp);
            for (int i = nodes.size() - 1; i >= 0; i--) {

                if (!list.contains(nodes.get(i))) {
                    stack.push(nodes.get(i));
                }
            }
        }
        return list;
    }
}
