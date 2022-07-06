package tree.diameter_of_binary_tree;

import tree.Node;

public class DiameterOfBinaryTree {
    int diameter(Node root) {
        return _diameter(root).diameter;
    }

    private Pair _diameter(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = _diameter(root.left);
        Pair right = _diameter(root.right);
        int diameter = 1 + left.height + right.height;
        return new Pair(Math.max(Math.max(left.diameter, diameter), right.diameter),
                1 + Math.max(left.height, right.height));
    }

}

class Pair {
    public int diameter;
    public int height;

    public Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}
