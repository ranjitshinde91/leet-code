package tree.count_of_nodes_in_a_complete_binary_tree;

import tree.Node;

public class CountOfNodesInCompleteBinaryTree {

    public int count(Node node) {
        if (node == null) {
            return 0;
        }
        int height = heightLeft(node);
        if (height == heightRight(node)) {
            return (int) Math.pow(2, height) - 1;
        }
        return 1 + count(node.left) + count(node.right);

    }

    private int heightLeft(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + heightLeft(node.left);
    }

    private int heightRight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + heightRight(node.right);
    }
}
