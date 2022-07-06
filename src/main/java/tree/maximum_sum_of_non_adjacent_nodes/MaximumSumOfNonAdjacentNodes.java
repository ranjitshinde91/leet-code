package tree.maximum_sum_of_non_adjacent_nodes;

import tree.Node;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfNonAdjacentNodes {

    static int getMaxSum(Node root) {
        return _getMaxSum(root).node;
    }

    static Sum _getMaxSum(Node root) {
        if (root == null) {
            return new Sum();
        }
        Sum leftSum = _getMaxSum(root.left);
        Sum rightSum = _getMaxSum(root.right);

        Sum sum = new Sum(
                Math.max(root.data + leftSum.left + leftSum.right + rightSum.left + rightSum.right,leftSum.node+rightSum.node),
                leftSum.node,
                rightSum.node
        );
        return sum;
    }

    static Map<Node, Integer> cache = new HashMap<>();

    static int getMaxSum2(Node root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            cache.get(root);
        }
        int sum1 = getMaxSum2(root.left) + getMaxSum2(root.right);
        int sum2 = root.data;
        if (root.left != null) {
            sum2 += getMaxSum2(root.left.left) + getMaxSum2(root.left.right);
        }
        if (root.right != null) {
            sum2 += getMaxSum2(root.right.left) + getMaxSum2(root.right.right);
        }
        int max = Math.max(sum1, sum2);
        System.out.println("sum for node " + root.data + " i " + sum2 + " e " + sum1);
        cache.put(root, max);
        return max;
    }
}

class Sum {
    int node;
    int left;
    int right;

    Sum() {
        this.node = 0;
        this.left = 0;
        this.right = 0;
    }

    Sum(int node, int left, int right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }

    public int max() {
        return Math.max(this.left, this.right);
    }

}
