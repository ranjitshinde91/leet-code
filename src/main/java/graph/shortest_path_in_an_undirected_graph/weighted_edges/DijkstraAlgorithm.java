package graph.shortest_path_in_an_undirected_graph.weighted_edges;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(source);

        for (int count = 0; count < v; count++) {
            int u = pq.poll();

            for (int p = 0; p < v; p++) {
                if (grid[u][p] != 0 && grid[u][p] + distance[u] < distance[p]) {
                    distance[p] = grid[u][p] + distance[u];
                    pq.add(p);
                }
            }
        }
        return distance;
    }
}
