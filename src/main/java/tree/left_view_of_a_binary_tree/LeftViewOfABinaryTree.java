package tree.left_view_of_a_binary_tree;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfABinaryTree {

    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        list.add(root.val);
        boolean addNextNode = false;
        while (queue.size() > 1) {
            Node poppedNode = queue.poll();
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

    ArrayList<Integer> leftViewRecursive(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        _leftView(root, list, 1);
        return list;
    }

    private void _leftView(Node node, ArrayList<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() < level) {
            list.add(node.val);
        }
        _leftView(node.left, list, level + 1);
        _leftView(node.right, list, level + 1);
    }
}
