package tree.level_order_traversal;

import java.util.*;

import static tree.level_order_traversal.TreeNode.NULL_NODE;

class TreeNode {
    public static TreeNode NULL_NODE = new TreeNode(-1);
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return List.of(List.of(root.val));
        }
        List<List<Integer>> elements = new ArrayList<>();

        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        treeNodes.add(root);
        treeNodes.add(NULL_NODE);

        ArrayList<Integer> integers = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
                TreeNode poppedNode = treeNodes.poll();
                 if(poppedNode == NULL_NODE && !integers.isEmpty()){
                      elements.add(integers);
                      integers = new ArrayList<>();
                      treeNodes.add(NULL_NODE);
                    }else{
                     integers.add(poppedNode.val);
                     if (poppedNode.left != null) {
                         treeNodes.add(poppedNode.left);
                     }
                     if (poppedNode.right != null) {
                         treeNodes.add(poppedNode.right);
                     }
                 }
        }
        return elements;
    }
}