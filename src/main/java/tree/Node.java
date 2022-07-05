package tree;

public class Node {
    public static Node NULL_NODE = new Node(-1);

    public int val;
    public Node left;
    public Node right;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
