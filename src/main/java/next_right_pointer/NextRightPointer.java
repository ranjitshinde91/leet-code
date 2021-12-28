package next_right_pointer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        Stack<Node> nodes2 = new Stack<>();

        nodes.add(root);
        nodes2.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();

            if (node.left != null) {
                nodes.add(node.left);
                nodes.add(node.right);

                nodes2.add(node.left);
                nodes2.add(node.right);
            }
        }

        Node last = null;
        int numberOfNodes = nodes2.size();
        int height = height(numberOfNodes);
        while (!nodes2.isEmpty()) {
            if (numberOfNodes == Math.pow(2, height) - 1) {
                last = null;
                height--;
            }
            numberOfNodes--;
            Node node = nodes2.pop();
            node.next = last;
            last = node;


        }
        return root;
    }

    public int height(int numberOfNodes) {
        int i = 1;
        while (numberOfNodes / 2 != 0) {
            i++;
            numberOfNodes = numberOfNodes / 2;
        }
        return i;
    }
}