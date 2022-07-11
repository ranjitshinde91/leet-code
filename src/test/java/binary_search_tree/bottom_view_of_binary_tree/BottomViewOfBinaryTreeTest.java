package binary_search_tree.bottom_view_of_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class BottomViewOfBinaryTreeTest {

    @Test
    void test1() {
        Node node = buildTree("10 20 30 40 50 N N N N N N");

        var bottomViewOfBinaryTree = new BottomViewOfBinaryTree();

        var traversal = bottomViewOfBinaryTree.view(node);

        assertThat(traversal).containsExactly(40, 20, 50, 30);
    }

    @Test
    void test2() {
        Node node = buildTree("10 20 30 N 50 N N N 60 N N");

        var bottomViewOfBinaryTree = new BottomViewOfBinaryTree();

        var traversal = bottomViewOfBinaryTree.view(node);

        assertThat(traversal).containsExactly(20, 50, 60);
    }

}