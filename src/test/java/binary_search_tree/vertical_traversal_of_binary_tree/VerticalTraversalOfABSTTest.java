package binary_search_tree.vertical_traversal_of_binary_tree;

import binary_search_tree.BinaryTreePrinter;
import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class VerticalTraversalOfABSTTest {

    @Test
    void test1() {
        Node node = buildTree("10 15 25 35 20 N N 40 N N 75 N N N 80 N N");

        var verticalTraversalOfABST = new VerticalTraversalOfABST();

        var traversal = verticalTraversalOfABST.traverse(node);

        assertThat(traversal).containsExactly(40, 35, 15, 10, 20, 25, 75, 80);
    }

    @Test
    void test2() {
        Node node = buildTree("1 2 3 4 5 6 7 N N N N N 8 N 9");

        var verticalTraversalOfABST = new VerticalTraversalOfABST();

        var traversal = verticalTraversalOfABST.traverse(node);

        assertThat(traversal).containsExactly(4, 2, 1, 5, 6, 3, 8, 7, 9);
    }
}