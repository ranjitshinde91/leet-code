package tree.lowest_common_ancestor_in_binary_tree;

import tree.Node;

public class LowestCommonAncestorInBinaryTree {

    Node lca(Node root, int n1, int n2) {
        Result result = _lca(root, n1, n2);
        if (result.firstFound && result.secondFound) {
            return result.ancestor;
        }
        return null;
    }

    private Result _lca(Node root, int n1, int n2) {
        if (root == null) {
            return new Result();
        }
        Result leftResult = _lca(root.left, n1, n2);
        if (leftResult.firstFound && leftResult.secondFound) {
            return leftResult;
        }
        Result rightResult = _lca(root.right, n1, n2);
        if (rightResult.firstFound && rightResult.secondFound) {
            return rightResult;
        }
        if ((leftResult.firstFound && rightResult.secondFound) ||
                (leftResult.secondFound && rightResult.firstFound)) {
            return Result.found(root);
        }
        return new Result(
                n1 == root.data || leftResult.firstFound || rightResult.firstFound,
                n2 == root.data || leftResult.secondFound || rightResult.secondFound,
                root
        );
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

    public static Result found(Node root) {
        return new Result(true, true, root);
    }

}