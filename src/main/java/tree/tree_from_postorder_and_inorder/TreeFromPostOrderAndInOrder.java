package tree.tree_from_postorder_and_inorder;

import tree.TreeNode;

public class TreeFromPostOrderAndInOrder {
    private int[] in;
    private int[] post;
    private int n;

    TreeNode iterative(int[] in, int[] post, int n) {
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

    private int preIndex;

    public TreeNode recursive(int[] in, int[] post, int length) {
        preIndex = length - 1;
        return _recursive(in, post, 0, length - 1);
    }

    private TreeNode _recursive(int[] in, int[] post, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(post[preIndex--]);

        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.right = _recursive(in, post, inIndex + 1, end);
        root.left = _recursive(in, post, start, inIndex - 1);
        return root;
    }
}

enum Position {
    R,
    L
}