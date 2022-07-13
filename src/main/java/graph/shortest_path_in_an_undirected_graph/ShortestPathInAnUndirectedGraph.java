package graph.shortest_path_in_an_undirected_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ShortestPathInAnUndirectedGraph {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjacencyList) {
        int v = adjacencyList.size();
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        distance[0] = 0;
        visited[0] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

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
