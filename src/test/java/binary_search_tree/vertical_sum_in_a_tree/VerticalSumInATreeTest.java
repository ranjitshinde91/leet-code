package binary_search_tree.vertical_sum_in_a_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class VerticalSumInATreeTest {

    @Test
    void test() {
        var ten = new Node(10);
        var twenty = new Node(20);
        var thirty = new Node(30);
        var five = new Node(5);
        var fifteen = new Node(15);

        ten.left = twenty;
        ten.right = thirty;

        twenty.left = five;
        twenty.right = fifteen;

        var verticalSumInABST = new VerticalSumInATree();

        var traversal = verticalSumInABST.sum(ten);

        assertThat(traversal).containsExactly(5, 20, 25, 30);
    }

    @Test
    void test2() {
        var ten = new Node(10);
        var fifteen = new Node(15);
        var twentyFive = new Node(25);
        var thirtyFive = new Node(35);
        var twenty = new Node(20);
        var seventyFive = new Node(75);
        var eighty = new Node(80);
        var forty = new Node(40);

        ten.left = fifteen;
        ten.right = twentyFive;

        fifteen.left = thirtyFive;
        fifteen.right = twenty;

        thirtyFive.left = forty;

        twenty.right = seventyFive;
        seventyFive.right = eighty;

        var verticalSumInABST = new VerticalSumInATree();

        var traversal = verticalSumInABST.sum(ten);

        assertThat(traversal).containsExactly(40, 35, 15, 30, 100, 80);
    }
}