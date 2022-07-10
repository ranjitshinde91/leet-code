package binary_search_tree.fix_a_bst_with_two_nodes_swapped;

import binary_search_tree.BinaryTreePrinter;
import org.junit.jupiter.api.Test;
import tree.Node;

import static tree.TreeFixture.buildTree;

class FixABSTWithTwoNodesSwappedTest {
    @Test
    void test() {
        Node root = buildTree("10 5 8 2 20 N N N N N N");
        var fixABSTWithTwoNodesSwapped = new FixABSTWithTwoNodesSwapped();

        Node node = fixABSTWithTwoNodesSwapped.correctBST(root);

        BinaryTreePrinter.printNode(node);


    }
}