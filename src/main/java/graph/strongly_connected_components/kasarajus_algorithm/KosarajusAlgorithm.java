package graph.strongly_connected_components.kasarajus_algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KosarajusAlgorithm {

    public int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        VertexByFinishTime[] vertices = orderedByFinishTime(v, adjacencyList);
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

    private int dfs(int v, VertexByFinishTime[] vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        int count = 0;
        boolean[] visited = new boolean[v];
        for (VertexByFinishTime vertexByFinishTime : vertices) {
            if (!visited[vertexByFinishTime.vertex]) {
                count++;
                _dfsTraversal(adjacencyList, vertexByFinishTime.vertex, visited);
            }
        }
        return count;
    }

    int time = 1;

    private VertexByFinishTime[] orderedByFinishTime(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];
        VertexByFinishTime[] finishTime = new VertexByFinishTime[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                _dfs(adjacencyList, i, visited, finishTime);
            }
        }

        Arrays.sort(finishTime, Collections.reverseOrder(Comparator.comparingInt(it -> it.finishTime)));
        return finishTime;
    }

    private void _dfs(ArrayList<ArrayList<Integer>> adjacencyList,
                      int vertex,
                      boolean[] visited,
                      VertexByFinishTime[] finishTime) {
        visited[vertex] = true;
        for (int edge : adjacencyList.get(vertex)) {
            if (!visited[edge]) {
                _dfs(adjacencyList, edge, visited, finishTime);
            }
        }
        finishTime[vertex] = new VertexByFinishTime(vertex, this.time);
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

class VertexByFinishTime {
    int vertex;
    int finishTime;

    public VertexByFinishTime(int vertex, int finishTime) {
        this.vertex = vertex;
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "VertexByFinishTime{" +
                "vertex=" + vertex +
                ", finishTime=" + finishTime +
                '}';
    }
}