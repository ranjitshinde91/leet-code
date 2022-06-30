package tree.tree_from_postorder_and_inorder;

import tree.TreeNode;

public class TreeFromPostOrderAndInOrder {
    private int[] in;
    private int[] post;
    private int n;

    TreeNode buildTree(int[] in, int[] post, int n) {
        this.in = in;
        this.post = post;
        this.n = n;

        TreeNode root = new TreeNode(post[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int e = this.post[i];
            TreeNode current = root;
            while (current != null) {
                Position position = position(e, current.val);
                if (position == Position.L) {
                    if (current.left == null) {
                        current.left = new TreeNode(e);
                        current = null;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new TreeNode(e);
                        current = null;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        return root;
    }

    private Position position(int e, int current) {
        for (int i = n - 1; i >= 0; i--) {
            if (in[i] == e) {
                return Position.R;
            }
            if (in[i] == current) {
                return Position.L;
            }
        }
        return Position.R;
    }
}

enum Position {
    R,
    L
}