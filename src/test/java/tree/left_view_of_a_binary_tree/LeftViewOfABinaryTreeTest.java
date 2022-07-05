package tree.left_view_of_a_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class LeftViewOfABinaryTreeTest {

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

        var leftViewOfABinaryTree = new LeftViewOfABinaryTree();

        var view = leftViewOfABinaryTree.leftView(three);

        assertThat(view).containsExactly(3, 9, 15);
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

        var leftViewOfABinaryTree = new LeftViewOfABinaryTree();

        var view = leftViewOfABinaryTree.leftViewRecursive(three);

        assertThat(view).containsExactly(3, 9, 15);
    }
}