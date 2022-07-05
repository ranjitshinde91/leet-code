package tree.level_order_traversal_in_spiral_form;

import tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversalInSpiralForm {

    ArrayList<Integer> iterative(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> traversal = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Queue<Node> queue = new ArrayDeque<>();

        boolean reverse = true;

        queue.add(root);

        while (!queue.isEmpty()) {

            int count = queue.size();
            for (int index = 0; index < count; index++) {
                Node poppedNode = queue.poll();

                if (reverse) {
                    stack.push(poppedNode);
                } else {
                    traversal.add(poppedNode.data);
                }
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
            if (reverse) {
                while (!stack.isEmpty()) {
                    traversal.add(stack.pop().data);
                }
            }
            reverse = !reverse;
        }
        return traversal;
    }
}
