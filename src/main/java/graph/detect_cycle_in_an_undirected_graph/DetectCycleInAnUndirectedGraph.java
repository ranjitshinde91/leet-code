package graph.detect_cycle_in_an_undirected_graph;

import java.util.ArrayList;

public class DetectCycleInAnUndirectedGraph {

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(adj, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;
        for (int edge : adj.get(vertex)) {
            if (!visited[edge]) {
                if (dfs(adj, edge, vertex, visited)) {
                    return true;
                }
            } else if (edge != parent) {
                return true;
            }
        }
        return false;
    }

}
