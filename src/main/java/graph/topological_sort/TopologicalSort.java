package graph.topological_sort;

import java.util.*;

public class TopologicalSort {

    int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
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
}
