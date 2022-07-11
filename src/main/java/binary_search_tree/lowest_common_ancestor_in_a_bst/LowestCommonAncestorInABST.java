package binary_search_tree.lowest_common_ancestor_in_a_bst;

import tree.Node;

public class LowestCommonAncestorInABST {


    public Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (n1 == root.data || n2 == root.data) {
            return root;
        }
        if ((n1 < root.data && n2 > root.data) || (n1 > root.data && n2 < root.data)) {
            return root;
        }

        if (n1 < root.data && n2 < root.data) {
            return lca(root.left, n1, n2);
        }
        return lca(root.right, n1, n2);
    }
}
