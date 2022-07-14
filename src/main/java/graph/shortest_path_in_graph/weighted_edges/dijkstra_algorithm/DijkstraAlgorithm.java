package graph.shortest_path_in_graph.weighted_edges.dijkstra_algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {


    // T.C. O(V^2)
    public int[] shortestPath(int[][] grid, int source) {

        int v = grid.length;
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        boolean[] mst = new boolean[v];

        for (int count = 0; count < v - 1; count++) {
            int u = -1;

            for (int i = 0; i < v; i++) {
                if (!mst[i] && (u == -1 || distance[i] < distance[u])) {
                    u = i;
                }
            }
            mst[u] = true;
            for (int p = 0; p < v; p++) {
                if (grid[u][p] != 0) {
                    distance[p] = Math.min(distance[p], grid[u][p] + distance[u]);
                }
            }
        }
        return distance;
    }

    public int[] optimized(int[][] grid, int source) {
        int v = grid.length;
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<Distance> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d.value));
        pq.add(new Distance(source, 0));

        for (int count = 0; count < v; count++) {
            Distance minDistance = pq.poll();
            int u = minDistance.vertex;
            System.out.println("polled "+ u);

            for (int p = 0; p < v; p++) {
                if (grid[u][p] != 0 && grid[u][p] + distance[u] < distance[p]) {
                    distance[p] = grid[u][p] + distance[u];
                    pq.add(new Distance(p, distance[p]));
                }
            }
        }
        return distance;
    }
}

class Distance {
    int vertex;
    int value;

    public Distance(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
}
