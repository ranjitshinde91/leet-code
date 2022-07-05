package tree.size_of_a_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class SizeOfABinaryTreeTest {
    @Test
    void test3() {
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var solution = new SizeOfABinaryTree();

        var size = solution.size(three);

        assertThat(size).isEqualTo(5);
    }
}