package binary_search_tree.operations;

import tree.Node;

public class BinarySearchTreeOperations {

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key == root.data) {
            return root;
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
        }
        else if (root.data == x) {
            return true;
        }
        else if (x < root.data) {
            return search(root.left, x);
        }
        return search(root.right, x);
    }

    public Node deleteNode(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                Node node = rightMost(root.left);
                root.data = node.data;
                root.left = deleteNode(root.left, node.data);
                return root;
            } else {
                Node node = leftMost(root.right);
                root.data = node.data;
                root.right = deleteNode(root.right, node.data);
                return root;
            }
        }
        if (x < root.data) {
            root.left = deleteNode(root.left, x);
        } else {
            root.right = deleteNode(root.right, x);
        }
        return root;
    }

    private static Node leftMost(Node node) {
        if (node.left == null) {
            return node;
        }
        return leftMost(node.left);
    }

    private static Node rightMost(Node root) {
        if (root.right == null) {
            return root;
        }
        return rightMost(root.right);
    }
}
