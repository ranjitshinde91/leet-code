package binary_search_tree.k_th_smallest_number_in_bst;

import tree.Node;

public class KThSmallestNumberInBST {

    public int kthSmallest(Node root, int k) {
        return _kthSmallest(root, k, new Index(0));
    }

    private int _kthSmallest(Node root, int k, Index index) {
        if (root == null) {
            return -1;
        }
        System.out.println(root.data + " k :" + k + " index " + index);
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
