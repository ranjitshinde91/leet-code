package graph.strongly_connected_components.kasarajus_algorithm;



import java.util.*;

public class KosarajusAlgorithm {

    public int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] vertices = orderedByFinishTime(v, adjacencyList);
        ArrayList<ArrayList<Integer>> reversed = reverseEdges(v, adjacencyList);
        return dfs(v, vertices, reversed);
    }

    private ArrayList<ArrayList<Integer>> reverseEdges(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adList.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adjacencyList.get(u)) {
                adList.get(v).add(u);
            }
        }
        return adList;
    }

    private int dfs(int v, int[] vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        int count = 0;
        boolean[] visited = new boolean[v];
        for (int vertex : vertices) {
            if (!visited[vertex]) {
                count++;
                _dfsTraversal(adjacencyList, vertex, visited);
            }
        }
        return count;
    }

    int time = 1;

    private int[] orderedByFinishTime(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];
        int[] finishTime = new int[v];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                _dfs(adjacencyList, i, visited, stack);
            }
        }

        int index = 0;
        while (!stack.isEmpty()) {
            finishTime[index++] = stack.pop();
        }
        return finishTime;
    }

    private void _dfs(ArrayList<ArrayList<Integer>> adjacencyList,
                      int vertex,
                      boolean[] visited,
                      ArrayDeque<Integer> stack) {
        visited[vertex] = true;
        for (int edge : adjacencyList.get(vertex)) {
            if (!visited[edge]) {
                _dfs(adjacencyList, edge, visited, stack);
            }
        }
        stack.push(vertex);
        this.time++;
    }

    private void _dfsTraversal(ArrayList<ArrayList<Integer>> adjacencyList,
                               int vertex,
                               boolean[] visited) {

        visited[vertex] = true;
        for (int edge : adjacencyList.get(vertex)) {
            if (!visited[edge]) {
                _dfsTraversal(adjacencyList, edge, visited);
            }
        }
    }
}