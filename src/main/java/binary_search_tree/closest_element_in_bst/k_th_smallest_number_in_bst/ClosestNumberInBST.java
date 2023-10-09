package binary_search_tree.closest_element_in_bst.k_th_smallest_number_in_bst;

import tree.Node;

class Index {
    int value;

    public Index(int value) {
        this.value = value;
    }

    public void increment() {
        this.value = this.value + 1;
    }

    public boolean matches(int k) {
        return this.value == k;
    }

}

public class ClosestNumberInBST {
    private Node root;

    public void insert(int e) {
        this.root = _insert(root, e);
    }

    private Node _insert(Node root, int e) {
        if (root == null) {
            return new Node(e);
        }
        if (e < root.data) {
            root.left = _insert(root.left, e);
            root.incrementLCount();
        } else {
            root.right = _insert(root.right, e);
        }
        return root;
    }

    public Node root() {
        return this.root;
    }

    public static int minDiff(Node root, int K) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.data == K) {
            return 0;
        }
        if (root.data < K) {
            return Math.abs(Math.min(Math.abs(root.data - K), minDiff(root.right, K)));
        }
        return Math.abs(Math.min(Math.abs(root.data - K), minDiff(root.left, K)));
    }

}
