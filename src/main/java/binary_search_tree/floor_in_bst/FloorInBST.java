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
        if (root.data < key) {
            int res = floor(root.right, key);
            if (res == -1) {
                return root.data;
            }
            return res;
        }
        return floor(root.left, key);
    }

}
