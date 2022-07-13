package graph;

import java.util.ArrayList;

public class GraphAdjacencyMatrixBuilder {

    public  ArrayList<ArrayList<Integer>> build(String input, GraphType type) {

        String[] s = input.split("\n");
        String[] s1 = s[0].split(" ");

        int V = Integer.parseInt(s1[0]);
        int E = Integer.parseInt(s1[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(i, new ArrayList<>());

        for (int i = 1; i <= E; i++) {
            String[] S = s[i].trim().split(" ");
            int u = Integer.parseInt(S[0]);
            int v = Integer.parseInt(S[1]);
            adj.get(u).add(v);
            if(type == GraphType.UNDIRECTED){
                adj.get(v).add(u);
            }
        }
        return adj;

    }


}
