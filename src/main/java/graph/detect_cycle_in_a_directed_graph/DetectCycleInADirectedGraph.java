package graph.detect_cycle_in_a_directed_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] backEdges = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                boolean isCycle = dfs(adj, i, visited, backEdges);
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, boolean[] backEdges) {
        visited[vertex] = true;
        backEdges[vertex] = true;
        for (int edge : adj.get(vertex)) {
            if (!visited[edge] && dfs(adj, edge, visited, backEdges)) {
                return true;
            } else if (backEdges[edge]) {
                return true;
            }
        }
        backEdges[vertex] = false;
        return false;
    }

    public boolean isCycleUsingKahnsAlgorithm(ArrayList<ArrayList<Integer>> adjacencyList) {
        int v = adjacencyList.size();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] inDegrees = inDegrees(adjacencyList, v);
        int count = 0;

        for (int i = 0; i < v; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            for (int e : adjacencyList.get(poll)) {
                inDegrees[e] = inDegrees[e] - 1;
                if (inDegrees[e] == 0) {
                    queue.add(e);
                }
            }
        }
        return count != v;
    }

    private int[] inDegrees(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] vertexEdges = new int[v];
        for (int i = 0; i < v; i++) {
            for (int edge : adj.get(i)) {
                vertexEdges[edge] = vertexEdges[edge] + 1;
            }
        }
        return vertexEdges;
    }
}
