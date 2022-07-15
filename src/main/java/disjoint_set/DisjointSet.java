package disjoint_set;

public class DisjointSet {
    private final int[] parent;
    private final int[] rank;

    public DisjointSet(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    public int find(int element) {
        if (this.parent[element] == element) {
            return element;
        }
        int res = find(this.parent[element]);
        this.parent[element] = res;
        return res;
    }

    public void union(int x, int y) {
        int xRep = find(x);
        int yRep = find(y);
        if (rank[xRep] < rank[yRep]) {
            this.parent[xRep] = yRep;
        } else if (rank[xRep] > rank[yRep]) {
            this.parent[yRep] = xRep;
        } else {
            this.parent[yRep] = xRep;
            rank[xRep] = rank[xRep] + 1;
        }
    }
}
