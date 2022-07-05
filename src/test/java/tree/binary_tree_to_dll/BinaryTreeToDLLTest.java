package tree.binary_tree_to_dll;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeToDLLTest {

    @Test
    void iterative() {
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var binaryTreeToDLL = new BinaryTreeToDLL();

        var root = binaryTreeToDLL.bToDLL(three);

        assertThat(root.data).isEqualTo(9);
        assertThat(root.left).isNull();
        assertThat(root.right).isEqualTo(three);

        assertThat(root.right.data).isEqualTo(3);
        assertThat(root.right.left).isEqualTo(nine);
        assertThat(root.right.right).isEqualTo(fifteen);

        assertThat(root.right.right.data).isEqualTo(15);
        assertThat(root.right.right.left).isEqualTo(three);
        assertThat(root.right.right.right).isEqualTo(twenty);
    }

    @Test
    void recursive() {
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var binaryTreeToDLL = new BinaryTreeToDLL();

        var root = binaryTreeToDLL.recursive(three);

        assertThat(root.data).isEqualTo(9);
        assertThat(root.left).isNull();
        assertThat(root.right).isEqualTo(three);

        assertThat(root.right.data).isEqualTo(3);
        assertThat(root.right.left).isEqualTo(nine);
        assertThat(root.right.right).isEqualTo(fifteen);

        assertThat(root.right.right.data).isEqualTo(15);
        assertThat(root.right.right.left).isEqualTo(three);
        assertThat(root.right.right.right).isEqualTo(twenty);
    }
}