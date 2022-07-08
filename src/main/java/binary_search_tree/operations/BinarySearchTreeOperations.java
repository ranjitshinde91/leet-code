package binary_search_tree.operations;

import tree.Node;

public class BinarySearchTreeOperations {

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    boolean search(Node root, int x) {
        if (root == null) {
            return false;
        } else if (root.data == x) {
            return true;
        } else if (x < root.data) {
            return search(root.left, x);
        }
        return search(root.right, x);
    }

    public Node deleteNode(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (x < root.data) {
            root.left = deleteNode(root.left, x);
        } else if (x > root.data) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (height(root.left) > height(root.right)) {
                    Node node = inOrderPredecessor(root.left);
                    root.data = node.data;
                    root.left = deleteNode(root.left, node.data);
                }else{
                    Node node = inorderSuccessor(root.right);
                    root.data = node.data;
                    root.right = deleteNode(root.right, node.data);
                }
            }
        }
        return root;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else return 1 + Math.max(height(node.left), height(node.right));
    }

    private static Node inorderSuccessor(Node node) {
        if (node.left == null) {
            return node;
        }
        return inorderSuccessor(node.left);
    }

    private static Node inOrderPredecessor(Node root) {
        if (root.right == null) {
            return root;
        }
        return inOrderPredecessor(root.right);
    }
}
