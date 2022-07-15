package graph.articulation_point;

import java.util.ArrayList;

public class ArticulationPoint {
    private int[] discoveryTime;
    private int[] low;
    private int[] parent;
    private boolean[] ap;
    private int time;

    public ArrayList<Integer> articulationPoints(int v, ArrayList<ArrayList<Integer>> adj) {
        this.discoveryTime = new int[v];
        this.low = new int[v];
        this.parent = new int[v];
        this.ap = new boolean[v];
        boolean[] visited = new boolean[v];
        this.time = 0;

        for (int i = 0; i < v; i++) {
            discoveryTime[i] = 0;
            parent[i] = -1;
            visited[i] = false;
            ap[i] = false;
        }

        for (int i = 0; i < v; i++)
            if (!visited[i])
                _dfs(adj, visited, 0);

        ArrayList<Integer> adjPoints = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (ap[i]) {
                adjPoints.add(i);
            }
        }
        return adjPoints;
    }

    private void _dfs(ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited,
                      int u) {
        int children = 0;
        visited[u] = true;

        this.time = this.time + 1;

        this.discoveryTime[u] = this.time;
        this.low[u] = this.time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                _dfs(adj, visited, v);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;

                if (parent[u] != -1 && low[v] >= discoveryTime[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u])
                low[u] = Math.min(low[u], this.discoveryTime[v]);
        }
    }
}
