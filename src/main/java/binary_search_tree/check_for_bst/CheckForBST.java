package binary_search_tree.check_for_bst;

import tree.Node;

public class CheckForBST {

    boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        return _extracted(root, new Range());
    }

    private boolean _extracted(Node node, Range range) {
        if (node == null) {
            return true;
        }

        return range.isBetween(node.data) &&
                _extracted(node.left, new Range(range.low, node.data)) &&
                _extracted(node.right, new Range(node.data, range.high));
    }

    private int previous = Integer.MIN_VALUE;

    public boolean isBSTInOrder(Node root) {
        if (root == null) {
            return true;
        }
        if (!isBSTInOrder(root.left)) return false;
        if (root.data <= previous) return false;
        previous = root.data;
        return isBSTInOrder(root.right);
    }
}

class Range {
    int low = Integer.MIN_VALUE;
    int high = Integer.MAX_VALUE;

    public Range() {

    }

    public Range(int low, int high) {
        this.low = low;
        this.high = high;
    }

    boolean isBetween(int e) {
        return low < e && high > e;
    }
}