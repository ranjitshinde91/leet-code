package tree;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public static final String LCOUNT = "lcount";
    public static Node NULL_NODE = new Node(-1);

    public int data;
    public Node left;
    public Node right;
    public Map<String, Object> additionalData = new HashMap<>();

    Node() {
        this.additionalData.put(LCOUNT, 0);
    }

    public Node(int data) {
        this.data = data;
        this.additionalData.put(LCOUNT, 0);
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void incrementLCount() {
        this.additionalData.computeIfPresent(LCOUNT, (a, b) -> (int) b + 1);
    }

    public int lcount() {
        return (int) this.additionalData.get(LCOUNT);
    }
}
