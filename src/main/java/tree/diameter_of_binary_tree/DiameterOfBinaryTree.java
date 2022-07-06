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
        int diameter = 1 + left.maxLength + right.maxLength;
        return new Pair(Math.max(Math.max(left.diameter, diameter), right.diameter),
                1 + Math.max(left.maxLength, right.maxLength));
    }

}

class Pair {
    public int diameter;
    public int maxLength;

    public Pair(int diameter, int maxLength) {
        this.diameter = diameter;
        this.maxLength = maxLength;
    }
}
