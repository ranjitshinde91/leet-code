package tree.size_of_a_binary_tree;

import tree.Node;

public class SizeOfABinaryTree {

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
