package graph.minimum_spanning_tree.kruskals_algorithm;

import disjoint_set.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {

    public int minimumSpanningTreeCost(List<Edge> edges1, int v) {
        List<Edge> edges = new ArrayList<>(edges1);
        DisjointSet disjointSet = new DisjointSet(v + 1);

        Collections.sort(edges, Comparator.comparingInt(it -> it.weight));

        int res = 0;
        for (int i = 0, s = 0; s < v - 1; i++) {
            Edge edge = edges.get(i);
            if (disjointSet.find(edge.source) != disjointSet.find(edge.destination)) {
                disjointSet.union(edge.source, edge.destination);
                res = res + edge.weight;
                s++;
            }
        }
        return res;
    }
}

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
