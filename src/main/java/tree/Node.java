package tree;

public class Node {
    public static Node NULL_NODE = new Node(-1);

    public int data;
    public Node left;
    public Node right;

    Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
