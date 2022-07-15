package graph.bridges;

import java.util.ArrayList;
import java.util.Objects;

public class BridgesInGraph {

    private int[] discoveryTime;
    private int[] low;
    private int[] parent;
    private int time;

    public ArrayList<Edge> bridges(int v, ArrayList<ArrayList<Integer>> adj) {
        this.discoveryTime = new int[v];
        this.low = new int[v];
        this.parent = new int[v];
        boolean[] visited = new boolean[v];
        ArrayList<Edge> bridges = new ArrayList<>();
        this.time = 0;

        for (int i = 0; i < v; i++) {
            discoveryTime[i] = 0;
            parent[i] = -1;
            visited[i] = false;
        }

        for (int i = 0; i < v; i++)
            if (!visited[i])
                _dfs(adj, visited, i, bridges);


        return bridges;
    }

    private void _dfs(ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited,
                      int u,
                      ArrayList<Edge> bridges) {
        visited[u] = true;

        this.time = this.time + 1;

        this.discoveryTime[u] = this.time;
        this.low[u] = this.time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                _dfs(adj, visited, v, bridges);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > discoveryTime[u]) {
                    bridges.add(new Edge(u, v));
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], this.discoveryTime[v]);
            }
        }
    }
}

class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source == edge.source && destination == edge.destination ||
                source == edge.destination && destination == edge.source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}

