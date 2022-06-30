package tree.binary_tree_to_dll;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeToDLLTest {

    @Test
    void iterative() {
        var three = new TreeNode(3);
        var nine = new TreeNode(9);
        var twenty = new TreeNode(20);
        var fifteen = new TreeNode(15);
        var seven = new TreeNode(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var binaryTreeToDLL = new BinaryTreeToDLL();

        var root = binaryTreeToDLL.bToDLL(three);

        assertThat(root.val).isEqualTo(9);
        assertThat(root.left).isNull();
        assertThat(root.right).isEqualTo(three);

        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.left).isEqualTo(nine);
        assertThat(root.right.right).isEqualTo(fifteen);

        assertThat(root.right.right.val).isEqualTo(15);
        assertThat(root.right.right.left).isEqualTo(three);
        assertThat(root.right.right.right).isEqualTo(twenty);
    }

    @Test
    void recursive() {
        var three = new TreeNode(3);
        var nine = new TreeNode(9);
        var twenty = new TreeNode(20);
        var fifteen = new TreeNode(15);
        var seven = new TreeNode(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var binaryTreeToDLL = new BinaryTreeToDLL();

        var root = binaryTreeToDLL.recursive(three);

        assertThat(root.val).isEqualTo(9);
        assertThat(root.left).isNull();
        assertThat(root.right).isEqualTo(three);

        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.left).isEqualTo(nine);
        assertThat(root.right.right).isEqualTo(fifteen);

        assertThat(root.right.right.val).isEqualTo(15);
        assertThat(root.right.right.left).isEqualTo(three);
        assertThat(root.right.right.right).isEqualTo(twenty);
    }
}