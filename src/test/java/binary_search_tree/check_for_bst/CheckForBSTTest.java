package binary_search_tree.check_for_bst;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class CheckForBSTTest {

    @Test
    void test1() {
        var three = new Node(4);
        three.left = new Node(2);
        three.right = new Node(5);

        var checkForBST = new CheckForBST();

        assertThat(checkForBST.isBST(three)).isTrue();
        assertThat(checkForBST.isBSTInOrder(three)).isTrue();
    }

    @Test
    void test2() {
        var three = new Node(4);
        three.left = new Node(6);
        three.right = new Node(5);

        var checkForBST = new CheckForBST();

        assertThat(checkForBST.isBST(three)).isFalse();
        assertThat(checkForBST.isBSTInOrder(three)).isFalse();
    }

    @Test
    void test3() {
        Node root = buildTree("3 1 5 N 2 4 8 N N N N 7 N 6 N");

        var checkForBST = new CheckForBST();

        assertThat(checkForBST.isBST(root)).isTrue();
        assertThat(checkForBST.isBSTInOrder(root)).isTrue();
    }
}