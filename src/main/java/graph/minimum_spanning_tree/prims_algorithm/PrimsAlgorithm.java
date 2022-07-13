package graph.minimum_spanning_tree.prims_algorithm;

import java.util.HashSet;

public class PrimsAlgorithm {


    public int minimumSpanningTree(int[][] grid) {
        int v = grid.length;
        HashSet<Integer> inMST = new HashSet<>();
        inMST.add(0);

        int cost = 0;
        while (inMST.size() != v) {
            int minimumCostEdge = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i : inMST) {
                for (int j = 0; j < v; j++) {
                    if (i != j && !inMST.contains(j) && grid[i][j] != 0 && grid[i][j] < minimumCostEdge) {
                        minimumCostEdge = grid[i][j];
                        vertex = j;
                    }
                }
            }
            cost = cost + minimumCostEdge;
            inMST.add(vertex);
        }
        return cost;
    }

    public int otherApproach(int[][] grid) {
        int v = grid.length;
        int[] key = new int[v];
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;
        boolean[] mst = new boolean[v];
        int res = 0;

        for (int count = 0; count < v; count++) {
            int u = -1;

            for (int i = 0; i < v; i++) {
                if (!mst[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mst[u] = true;
            res = res + key[u];

            for (int p = 0; p < v; p++) {
                if (!mst[p] && grid[u][p] != 0 && grid[u][p] < key[p]) {
                    key[p] = grid[u][p];
                }
            }
        }
        return res;
    }
}
