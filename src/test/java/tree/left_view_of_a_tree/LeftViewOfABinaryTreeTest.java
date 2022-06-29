package tree.left_view_of_a_tree;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class LeftViewOfABinaryTreeTest {

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

        var leftViewOfABinaryTree = new LeftViewOfABinaryTree();

        var view = leftViewOfABinaryTree.leftView(three);

        assertThat(view).containsExactly(3, 9, 15);
    }

}