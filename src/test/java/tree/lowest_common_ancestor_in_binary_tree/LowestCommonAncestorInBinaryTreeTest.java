package tree.lowest_common_ancestor_in_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorInBinaryTreeTest {

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

        var lowestCommonAncestorInBinaryTree = new LowestCommonAncestorInBinaryTree();

        var ancestor = lowestCommonAncestorInBinaryTree.lca(three, 15, 7);
        assertThat(ancestor.data).isEqualTo(20);

        var ancestor2 = lowestCommonAncestorInBinaryTree.lca(three, 9, 7);
        assertThat(ancestor2.data).isEqualTo(3);

        var ancestor3 = lowestCommonAncestorInBinaryTree.lca(three, 20, 7);
        assertThat(ancestor3.data).isEqualTo(20);

        var ancestor4 = lowestCommonAncestorInBinaryTree.lca(three, 20, 40);
        assertThat(ancestor4).isNull();
    }
}