package tree.binary_tree_to_dll;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL {

    TreeNode bToDLL(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderTraversal(queue, root);
        TreeNode head = queue.poll();
        TreeNode lastNode = head;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            lastNode.right = temp;
            temp.left = lastNode;

            lastNode = temp;
        }
        return head;
    }

    private void inOrderTraversal(Queue<TreeNode> queue, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(queue, node.left);
        queue.add(node);
        inOrderTraversal(queue, node.right);
    }

    private TreeNode previous = null;

    TreeNode recursive(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode head = recursive(root.left);
        if (previous == null) {
            head = root;
        } else {
            root.left = previous;
            previous.right = root;
        }
        previous = root;
        recursive(root.right);
        return head;
    }
}
