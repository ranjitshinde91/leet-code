package graph.shortest_path_in_graph.weighted_edges.bellman_ford_algorithm;

import java.util.ArrayList;
import java.util.Map;

public class BellmanFordAlgorithm {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjacencyList, int source, Map<String, Integer> weights) {
        int v = adjacencyList.size();
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for (int count = 0; count < v - 1; count++) {
            for (int u = 0; u < v; u++) {
                ArrayList<Integer> edges = adjacencyList.get(u);
                for (int p : edges) {
                    if (distance[u] != Integer.MAX_VALUE && distance[p] > distance[u] + weight(weights, u, p)) {
                        distance[p] = distance[u] + weight(weights, u, p);
                    }
                }
            }
        }
        return distance;
    }

    private int weight(Map<String, Integer> weights, int u, int v) {
        return weights.get(u + "->" + v);
    }
}
