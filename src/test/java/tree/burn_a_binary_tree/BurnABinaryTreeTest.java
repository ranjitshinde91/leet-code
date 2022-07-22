package tree.burn_a_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class BurnABinaryTreeTest {

    @Test
    void test1() {
        Node root = buildTree("3 9 20 15 7 N N");

        var burnABinaryTree = new BurnABinaryTree();

        var result = burnABinaryTree.burn(root, 7);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void test2() {
        Node root = buildTree("3 9 20 15 7 N N");

        var burnABinaryTree = new BurnABinaryTree();

        var result = burnABinaryTree.burn(root, 70);

        assertThat(result).isEqualTo(-1);
    }

}