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
}
