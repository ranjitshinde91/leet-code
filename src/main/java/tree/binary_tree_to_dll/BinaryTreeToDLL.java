package tree.binary_tree_to_dll;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL {

    Node bToDLL(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        inOrderTraversal(queue, root);
        Node head = queue.poll();
        Node lastNode = head;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            lastNode.right = temp;
            temp.left = lastNode;

            lastNode = temp;
        }
        return head;
    }

    private void inOrderTraversal(Queue<Node> queue, Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(queue, node.left);
        queue.add(node);
        inOrderTraversal(queue, node.right);
    }

    private Node previous = null;

    Node recursive(Node root) {
        if (root == null) {
            return root;
        }
        Node head = recursive(root.left);
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
