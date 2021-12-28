package binary_tree_level_order;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return List.of(List.of(root.val));
        }
        List<List<Integer>> elements = new ArrayList<>();

        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = treeNodes.pop();
                integers.add(poppedNode.val);

                if (poppedNode.left != null) {
                    treeNodes.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    treeNodes.add(poppedNode.right);
                }
            }
            elements.add(integers);
        }
        return elements;
    }
}