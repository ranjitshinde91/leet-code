package graph.strongly_connected_components.tarjans_algorithm;

import java.util.*;

public class TarjansAlgorithm {

    private int time = 1;

    public ArrayList<ArrayList<Integer>> stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] disTime = new int[v];
        int[] low = new int[v];
        this.time = 1;

        for (int i = 0; i < v; i++) {
            disTime[i] = -1;
            low[i] = -1;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> backEdges = new HashSet<>();
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (disTime[i] == -1) {
                _dfs(adjacencyList, i, disTime, low, stack, backEdges, components);
            }
        }
        components.sort(Comparator.comparing(a -> a.get(0)));
        return components;
    }

    private void _dfs(ArrayList<ArrayList<Integer>> adjacencyList, int u, int[] disTime, int[] low, ArrayDeque<Integer> stack, HashSet<Integer> backEdges, ArrayList<ArrayList<Integer>> components) {
        disTime[u] = this.time;
        low[u] = this.time;

        stack.push(u);
        backEdges.add(u);

        this.time = this.time + 1;

        for (int v : adjacencyList.get(u)) {
            if (disTime[v] == -1) {
                _dfs(adjacencyList, v, disTime, low, stack, backEdges, components);
                low[u] = Math.min(low[u], low[v]);
            } else if (backEdges.contains(v)) {
                low[u] = Math.min(low[u], disTime[v]);
            }
        }
        int w = -1;
        if (disTime[u] == low[u]) {
            ArrayList<Integer> component = new ArrayList<>();
            while (w != u) {
                w = stack.pop();
                component.add(w);
                backEdges.remove(w);
            }
            Collections.sort(component);
            components.add(component);
        }
    }
}
