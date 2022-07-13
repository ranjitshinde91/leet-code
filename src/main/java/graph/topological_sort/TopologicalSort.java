package graph.topological_sort;

import java.util.*;

public class TopologicalSort {

    int[] bfsBased(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] sorted = new int[v];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        int[] inDegrees = inDegrees(adj, v);
        for (int i = 0; i < v; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            sorted[index++] = vertex;

            for (int edge : adj.get(vertex)) {
                inDegrees[edge] = inDegrees[edge] - 1;
                if (inDegrees[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        return sorted;
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

    // Original implementation uses Stack, but here using sorted array to act  as stack to avoid extra space
    public int[] dfsBased(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] sorted = new int[v];
        boolean[] visited = new boolean[v];

        Index index = new Index(v - 1);
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                _dfs(adjacencyList, i, visited, sorted, index);
            }
        }
        return sorted;
    }

    private static void _dfs(ArrayList<ArrayList<Integer>> adjacencyList, int vertex, boolean[] visited, int[] sorted, Index index) {
        visited[vertex] = true;
        for (int edge : adjacencyList.get(vertex)) {
            if (!visited[edge]) {
                _dfs(adjacencyList, edge, visited, sorted, index);
            }
        }
        sorted[index.val] = vertex;
        index.val = index.val - 1;
    }
}

class Index {
    int val;

    public Index(int val) {
        this.val = val;
    }
}
