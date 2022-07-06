package tree.count_of_nodes_in_a_complete_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;
import tree.diameter_of_binary_tree.DiameterOfBinaryTree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountOfNodesInCompleteBinaryTreeTest {

    @Test
    void recursive() {
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = twenty;
        three.right = nine;

        var countOfNodesInCompleteBinaryTree = new CountOfNodesInCompleteBinaryTree();

        var view = countOfNodesInCompleteBinaryTree.count(three);

        assertThat(view).isEqualTo(5);
    }

}