package binary_search_tree.lowest_common_ancestor_in_a_bst;

import binary_search_tree.BinaryTreePrinter;
import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class LowestCommonAncestorInABSTTest {

    @Test
    void test1() {

        Node root = buildTree("8 1 14 N 6 9 20 5 7 N 10 15 N N N N N N N N N");

        var lowestCommonAncestorInABST = new LowestCommonAncestorInABST();

        BinaryTreePrinter.printNode(root);

        var node = lowestCommonAncestorInABST.lca(root, 9, 6);

        assertThat(node.data).isEqualTo(8);
    }
}