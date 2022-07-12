package graph.detect_cycle_in_a_directed_graph;

import java.util.ArrayList;

public class DetectCycleInADirectedGraph {

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] backEdges = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                boolean isCycle = _isCycle(adj, i, visited, backEdges);
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean _isCycle(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, boolean[] backEdges) {
        visited[vertex] = true;
        backEdges[vertex] = true;
        for (int edge : adj.get(vertex)) {
            if (!visited[edge] && _isCycle(adj, edge, visited, backEdges)) {
                return true;
            } else if (backEdges[edge]) {
                return true;
            }
        }
        backEdges[vertex] = false;
        return false;
    }

}
