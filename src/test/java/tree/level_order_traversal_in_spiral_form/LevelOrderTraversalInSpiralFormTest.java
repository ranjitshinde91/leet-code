package tree.level_order_traversal_in_spiral_form;

import org.junit.jupiter.api.Test;
import tree.Node;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LevelOrderTraversalInSpiralFormTest {

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

        var levelOrderTraversalInSpiralForm = new LevelOrderTraversalInSpiralForm();
        List<Integer> lists = levelOrderTraversalInSpiralForm.iterative(three);

        System.out.println(lists);
        assertThat(lists).containsExactly(3, 9, 20, 7, 15);
    }
}