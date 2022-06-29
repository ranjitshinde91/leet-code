package tree.left_view_of_a_tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfABinaryTree {

    public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        list.add(root.val);
        boolean addNextNode = false;
        while (queue.size() > 1) {
            TreeNode poppedNode = queue.poll();
            if (addNextNode) {
                list.add(poppedNode.val);
                addNextNode = false;
            }
            if (poppedNode == null) {
                addNextNode = true;
                queue.add(null);
            } else {
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
        }
        return list;
    }
}
