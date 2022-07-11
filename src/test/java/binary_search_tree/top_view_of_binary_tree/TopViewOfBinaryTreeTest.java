package binary_search_tree.top_view_of_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class TopViewOfBinaryTreeTest {

    @Test
    void test1() {
        Node node = buildTree("10 20 50 30 40 60 70 N N N N N N N N");

        var topViewOfBinaryTree = new TopViewOfBinaryTree();

        var traversal = topViewOfBinaryTree.view(node);

        assertThat(traversal).containsExactly(30, 20, 10, 50, 70);
    }

    @Test
    void test2() {
        Node node = buildTree("1 2 3 N 4 N N N 5 N N");

        var topViewOfBinaryTree = new TopViewOfBinaryTree();

        var traversal = topViewOfBinaryTree.view(node);

        assertThat(traversal).containsExactly(2, 1, 3);
    }
}