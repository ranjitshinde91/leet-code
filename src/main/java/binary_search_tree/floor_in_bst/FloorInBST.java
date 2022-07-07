package binary_search_tree.floor_in_bst;

import tree.Node;

public class FloorInBST {

    int floor(Node root, int key) {
        if (root == null) {
            return -1;
        }
        if (key == root.data) {
            return root.data;
        }
        int res = -1;
        if (root.data > key) {
            res = floor(root.left, key);
        } else {
            res = floor(root.right, key);
            if (res == -1) {
                return root.data;
            }
        }
        return res;
    }

}
