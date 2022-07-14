package graph.shortest_path_in_graph.unweighted_edges;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ShortestPathInUnWeightedEdgeGraph {

    public int[] bfsBased(ArrayList<ArrayList<Integer>> adjacencyList, int source) {
        int v = adjacencyList.size();
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        distance[source] = 0;
        visited[source] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i : adjacencyList.get(poll)) {
                if (!visited[i]) {
                    distance[i] = distance[poll] + 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return distance;
    }
}
