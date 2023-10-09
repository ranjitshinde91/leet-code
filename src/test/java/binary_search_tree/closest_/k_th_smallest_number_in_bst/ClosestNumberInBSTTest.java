package binary_search_tree.closest_.k_th_smallest_number_in_bst;

import binary_search_tree.BinaryTreePrinter;
import binary_search_tree.closest_element_in_bst.k_th_smallest_number_in_bst.ClosestNumberInBST;
import binary_search_tree.k_th_smallest_number_in_bst.KThSmallestNumberInBST;
import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class ClosestNumberInBSTTest {

    @Test
    void test() {
        var closestNumberInBST = new ClosestNumberInBST();
        closestNumberInBST.insert(10);
        closestNumberInBST.insert(2);
        closestNumberInBST.insert(11);
        closestNumberInBST.insert(1);
        closestNumberInBST.insert(5);
        closestNumberInBST.insert(3);
        closestNumberInBST.insert(6);
        closestNumberInBST.insert(4);

        Node root = closestNumberInBST.root();

        BinaryTreePrinter.printNode(root);

        assertThat(ClosestNumberInBST.minDiff(root, 13)).isEqualTo(2);
        assertThat(ClosestNumberInBST.minDiff(root, 9)).isEqualTo(1);
        assertThat(ClosestNumberInBST.minDiff(root, 9)).isEqualTo(1);
        assertThat(ClosestNumberInBST.minDiff(root, 7)).isEqualTo(1);
    }
}