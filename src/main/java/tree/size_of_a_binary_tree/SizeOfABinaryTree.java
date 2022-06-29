package tree.size_of_a_binary_tree;

import tree.TreeNode;

public class SizeOfABinaryTree {

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
