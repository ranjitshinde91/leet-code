package tree.lowest_common_ancestor_in_binary_tree;

import tree.Node;

public class LowestCommonAncestorInBinaryTree {

    Node lca(Node root, int n1, int n2) {
        return _lca(root, n1, n2).ancestor;
    }

    private Result _lca(Node root, int n1, int n2) {
        if (root == null) {
            return new Result();
        }
        Result leftResult = _lca(root.left, n1, n2);
        if (leftResult.isAncestor()) {
            return leftResult;
        }
        Result rightResult = _lca(root.right, n1, n2);
        if (rightResult.isAncestor()) {
            return rightResult;
        }
        if (isCurrentNodeAncestor(root, n1, n2, leftResult, rightResult)) {
            return Result.found(root);
        }
        return new Result(
                n1 == root.data || leftResult.firstFound || rightResult.firstFound,
                n2 == root.data || leftResult.secondFound || rightResult.secondFound
        );
    }

    private boolean isCurrentNodeAncestor(Node root, int n1, int n2, Result leftResult, Result rightResult) {
        if (leftResult.firstFound && rightResult.secondFound) {
            return true;
        }
        if (leftResult.secondFound && rightResult.firstFound) {
            return true;
        }
        if (n1 == root.data && (leftResult.secondFound || rightResult.secondFound)) {
            return true;
        }
        if (n2 == root.data && (leftResult.firstFound || rightResult.firstFound)) {
            return true;
        }
        return false;
    }
}

class Result {
    public boolean firstFound = false;
    public boolean secondFound = false;
    public Node ancestor = null;

    public Result() {
    }

    public Result(boolean firstFound, boolean secondFound, Node ancestor) {
        this.firstFound = firstFound;
        this.secondFound = secondFound;
        this.ancestor = ancestor;
    }

    public Result(boolean firstFound, boolean secondFound) {
        this(firstFound, secondFound, null);
    }

    public static Result found(Node root) {
        return new Result(true, true, root);
    }

    public boolean isAncestor() {
        return this.firstFound && this.secondFound;
    }

}