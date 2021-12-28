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
            ArrayDeque<TreeNode> temp = new ArrayDeque<>();
            while (!treeNodes.isEmpty()) {
                TreeNode poppedNode = treeNodes.pop();
                integers.add(poppedNode.val);

                if (poppedNode.left != null) {
                    temp.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    temp.add(poppedNode.right);
                }
            }
            elements.add(integers);
            treeNodes = temp;
        }
        return elements;
    }
}