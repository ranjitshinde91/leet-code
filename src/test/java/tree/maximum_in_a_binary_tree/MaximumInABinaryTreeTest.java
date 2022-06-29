package tree.maximum_in_a_binary_tree;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumInABinaryTreeTest {
    @Test
    void test3() {
        var three = new TreeNode(3);
        var nine = new TreeNode(9);
        var twenty = new TreeNode(20);
        var fifteen = new TreeNode(15);
        var seven = new TreeNode(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var maximumInABinaryTree = new MaximumInABinaryTree();
        int max = maximumInABinaryTree.max(three);

        assertThat(max).isEqualTo(20);
    }

}