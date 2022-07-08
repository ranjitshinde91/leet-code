package binary_search_tree.k_th_smallest_number_in_bst;

import binary_search_tree.BinaryTreePrinter;
import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class KThSmallestNumberInBSTTest {

    @Test
    void test() {
        var kThSmallestNumberInBST = new KThSmallestNumberInBST();
        kThSmallestNumberInBST.insert(20);
        kThSmallestNumberInBST.insert(10);
        kThSmallestNumberInBST.insert(30);
        kThSmallestNumberInBST.insert(5);
        kThSmallestNumberInBST.insert(15);
        kThSmallestNumberInBST.insert(25);
        kThSmallestNumberInBST.insert(35);

        Node root = kThSmallestNumberInBST.root();

        BinaryTreePrinter.printNode(root);

        assertThat(kThSmallestNumberInBST.kthSmallest(root, 2)).isEqualTo(10);
        assertThat(kThSmallestNumberInBST.kthSmallest(root, 3)).isEqualTo(15);
        assertThat(kThSmallestNumberInBST.kthSmallest(root, 4)).isEqualTo(20);

        assertThat(kThSmallestNumberInBST.kthSmallestOptimized(2)).isEqualTo(10);
        assertThat(kThSmallestNumberInBST.kthSmallestOptimized(3)).isEqualTo(15);
        assertThat(kThSmallestNumberInBST.kthSmallestOptimized(4)).isEqualTo(20);


    }
}