package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphAdjacencyMatrixBuilder {
    private Map<String, Integer> weights;

    public ArrayList<ArrayList<Integer>> build(String input, GraphType type) {
        return build(input, type, false);
    }

    public ArrayList<ArrayList<Integer>> build(String input, GraphType type, boolean isWeight) {
        String[] s = input.split("\n");
        String[] s1 = s[0].split(" ");

        if (isWeight) {
            this.weights = new HashMap<>();
        }

        int V = Integer.parseInt(s1[0]);
        int E = Integer.parseInt(s1[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(i, new ArrayList<>());

        for (int i = 1; i <= E; i++) {
            String[] S = s[i].trim().split(" ");
            int u = Integer.parseInt(S[0]);
            int v = Integer.parseInt(S[1]);
            adj.get(u).add(v);
            if (type == GraphType.UNDIRECTED) {
                adj.get(v).add(u);
            }
            if (isWeight) {
                int weight = Integer.parseInt(S[2]);
                this.weights.put(key(u, v), weight);
            }
        }
        return adj;

    }

    private String key(int u, int v) {
        return u + "->" + v;
    }


    public Map<String, Integer> weights() {
        return this.weights;
    }
}
