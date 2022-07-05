package tree.maximum_in_a_binary_tree;

import tree.Node;

public class MaximumInABinaryTree {

    public int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(
                node.data,
                Math.max(
                        max(node.left),
                        max(node.right)
                )
        );
    }
}
