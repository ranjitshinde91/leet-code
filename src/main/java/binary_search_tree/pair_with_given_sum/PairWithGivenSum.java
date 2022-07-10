package binary_search_tree.pair_with_given_sum;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class PairWithGivenSum {

    boolean findPair(Node root, int x) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) == x) {
                return true;
            } else if (list.get(i) + list.get(j) > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inorderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.data);
            inorderTraversal(node.right, list);
        }
    }
}
