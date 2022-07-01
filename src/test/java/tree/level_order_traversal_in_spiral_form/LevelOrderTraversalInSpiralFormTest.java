package tree.level_order_traversal_in_spiral_form;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LevelOrderTraversalInSpiralFormTest {

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

        var levelOrderTraversalInSpiralForm = new LevelOrderTraversalInSpiralForm();
        List<Integer> lists = levelOrderTraversalInSpiralForm.iterative(three);

        System.out.println(lists);
        assertThat(lists).containsExactly(3, 9, 20, 7, 15);
    }
}