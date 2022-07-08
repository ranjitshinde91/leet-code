package binary_search_tree.k_th_smallest_number_in_bst;

import tree.Node;

public class KThSmallestNumberInBST {
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

    public int kthSmallestOptimized(int k) {
        return _kthSmallestOptimized(this.root, k);
    }

    private int _kthSmallestOptimized(Node node, int k) {
        if (node != null) {
            if (k == node.lcount() + 1) {
                return node.data;
            } else if (k <= node.lcount()) {
                return _kthSmallestOptimized(node.left, k);
            }
            return _kthSmallestOptimized(node.right, k - node.lcount() - 1);
        }
        return -1;
    }

    public int kthSmallest(Node root, int k) {
        return _kthSmallest(root, k, new Index(0));
    }

    private int _kthSmallest(Node root, int k, Index index) {
        if (root == null) {
            return -1;
        }
        int res = _kthSmallest(root.left, k, index);
        if (res != -1) {
            return res;
        }
        index.increment();
        if (index.matches(k)) {
            return root.data;
        }
        return _kthSmallest(root.right, k, index);
    }

    public Node root() {
        return this.root;
    }
}

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
