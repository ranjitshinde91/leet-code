package graph.shortest_path_in_a_directed_acyclic_graph.topological_sort_based;

import graph.topological_sort.TopologicalSort;

import java.util.ArrayList;
import java.util.Map;

public class ShortestPathInADAG {


    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjacencyList, int source, Map<String, Integer> weights) {
        int V = adjacencyList.size();

        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        int[] topologicalSort = new TopologicalSort().dfsBased(adjacencyList.size(), adjacencyList);
        for (int i = 0; i < topologicalSort.length; i++) {
            int u = topologicalSort[i];
            for (int v : adjacencyList.get(u)) {
                if (distance[u] != Integer.MAX_VALUE) {
                    distance[v] = Math.min(distance[v], distance[u] + weight(weights, u, v));
                }
            }
        }
        return distance;
    }

    private int weight(Map<String, Integer> weights, int u, int v) {
        return weights.get(u + "->" + v);
    }
}
