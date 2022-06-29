package tree.maximum_in_a_binary_tree;

import tree.TreeNode;

public class MaximumInABinaryTree {

    public int max(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(
                node.val,
                Math.max(
                        max(node.left),
                        max(node.right)
                )
        );
    }
}
