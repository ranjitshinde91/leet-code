package graph.breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstSearch {

    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        list.add(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            ArrayList<Integer> temp = adj.get(index);
            for (int i = 0; i < temp.size(); i++) {
                int e = temp.get(i);
                if (!list.contains(e)) {
                    list.add(e);
                    queue.add(e);
                }
            }

        }
        return list;
    }
}
