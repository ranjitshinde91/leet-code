package tree.level_order_traversal;

import org.junit.jupiter.api.Test;
import tree.Node;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LevelOrderTraversalTest {

    @Test
    void test1() {
        var solution = new LevelOrderTraversal();

        List<List<Integer>> lists = solution.levelOrder(null);

        assertThat(lists).isEmpty();
    }

    @Test
    void test2() {
        var solution = new LevelOrderTraversal();
        var treeNode = new Node(1);

        List<List<Integer>> lists = solution.levelOrder(treeNode);

        assertThat(lists).containsExactly(List.of(1));
    }

    @Test
    void test3() {
        var solution = new LevelOrderTraversal();
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        List<List<Integer>> lists = solution.levelOrder(three);

        assertThat(lists).containsExactly(List.of(3), List.of(9, 20), List.of(15, 7));
    }

}