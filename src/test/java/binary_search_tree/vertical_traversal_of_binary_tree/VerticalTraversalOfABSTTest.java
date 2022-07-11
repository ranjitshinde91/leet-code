package binary_search_tree.vertical_traversal_of_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class VerticalTraversalOfABSTTest {

    @Test
    void test1() {
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

        var verticalTraversalOfABST = new VerticalTraversalOfABST();

        var traversal = verticalTraversalOfABST.traverse(ten);

        assertThat(traversal).containsExactly(40, 35, 15, 10, 20, 25, 75, 80);
    }

    @Test
    void test2() {
        Node node = buildTree("1 2 3 4 5 6 7 N N N N N 8 N 9");

        var verticalTraversalOfABST = new VerticalTraversalOfABST();

        var traversal = verticalTraversalOfABST.traverse(node);

        assertThat(traversal).containsExactly(4, 2, 1, 5, 6, 3, 8, 7, 9);
    }
}