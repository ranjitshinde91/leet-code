package tree.burn_a_binary_tree;

import tree.Node;

public class BurnABinaryTree {

    public int burn(Node node, int n) {
         _burn(node, n, new Distance(-1));
         return res;
    }

    private int res = -1;

    private int _burn(Node node, int leaf, Distance distance) {
        if (node == null) {
            return 0;
        }
        if (node.data == leaf) {
            distance.val = 0;
            return 1;
        }
        Distance ldistance = new Distance(-1);
        Distance rdistance = new Distance(-1);
        int lh = _burn(node.left, leaf, distance);
        int rh = _burn(node.right, leaf, rdistance);

        if (ldistance.val != -1) {
            distance.val = ldistance.val + 1;
            res = Math.max(res, rh + distance.val);
        } else if (rdistance.val != -1) {
            distance.val = rdistance.val + 1;
            res = Math.max(res, lh + distance.val);
        }
        return Math.max(lh, rh) + 1;
    }

}

class Distance {
    int val;

    public Distance(int val) {
        this.val = val;
    }
}