package binary_search_tree.avl_tree;

import tree.Node;

public class AVLTree {

    private Node root;

    public AVLTree(int value) {
        this.root = new Node(value);
    }

    public void insert(int e) {
        this.root = _insert(root, e);
    }

    private Node _insert(Node node, int e) {
        if (node == null) {
            return new Node(e);
        }
        if (e < node.data) {
            node.left = _insert(node.left, e);
        } else if (e > node.data) {
            node.right = _insert(node.right, e);
        }
        if (balanceFactor(node) == 2 || balanceFactor(node) == -2) {
            return performRotation(root);
        }
        return node;
    }

    private Node performRotation(Node node) {
        if (balanceFactor(node) == 2 && balanceFactor(node.left) == 1) {
            return LLRotation(node);
        } else if (balanceFactor(node) == 2 && balanceFactor(node.left) == -1) {
            return LRRotation(node);
        } else if (balanceFactor(node) == -2 && balanceFactor(node.right) == -1) {
            return RRRotation(node);
        } else if (balanceFactor(node) == -2 && balanceFactor(node.right) == 1) {
            return RLRotation(node);
        }
        return node;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node LLRotation(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node LRRotation(Node node) {
        Node left = node.left;

        Node temp = left.right;
        left.right = temp.left;
        node.left = temp.right;

        temp.left = left;
        temp.right = node;

        return temp;
    }

    private Node RLRotation(Node node) {
        Node right = node.right;
        Node temp = right.left;

        right.left = temp.right;
        node.right = temp.left;

        temp.left = node;
        temp.right = right;

        return temp;
    }

    private Node RRRotation(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public Node root() {
        return this.root;
    }
}
