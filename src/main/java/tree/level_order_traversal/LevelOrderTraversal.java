package tree.level_order_traversal;

import tree.Node;

import java.util.*;

import static tree.Node.NULL_NODE;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return List.of(List.of(root.val));
        }
        List<List<Integer>> elements = new ArrayList<>();

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        nodes.add(NULL_NODE);

        ArrayList<Integer> integers = new ArrayList<>();
        while (!nodes.isEmpty()) {
                Node poppedNode = nodes.poll();
                 if(poppedNode == NULL_NODE && !integers.isEmpty()){
                      elements.add(integers);
                      integers = new ArrayList<>();
                      nodes.add(NULL_NODE);
                    }else{
                     integers.add(poppedNode.val);
                     if (poppedNode.left != null) {
                         nodes.add(poppedNode.left);
                     }
                     if (poppedNode.right != null) {
                         nodes.add(poppedNode.right);
                     }
                 }
        }
        return elements;
    }
}