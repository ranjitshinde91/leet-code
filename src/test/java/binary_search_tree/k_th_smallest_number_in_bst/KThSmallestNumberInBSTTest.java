package binary_search_tree.k_th_smallest_number_in_bst;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class KThSmallestNumberInBSTTest {

    @Test
    void test() {
        var twenty = new Node(20);
        Node ten = new Node(10);
        Node thirty = new Node(30);
        Node five = new Node(5);
        Node fifteen = new Node(15);
        Node twentyFive = new Node(25);
        Node thirtyFive = new Node(35);

        twenty.left = ten;
        twenty.right = thirty;

        ten.left = five;
        ten.right = fifteen;

        thirty.left = twentyFive;
        thirty.right = thirtyFive;

        var kThSmallestNumberInBST = new KThSmallestNumberInBST();

        assertThat(kThSmallestNumberInBST.kthSmallest(twenty, 2)).isEqualTo(10);
        assertThat(kThSmallestNumberInBST.kthSmallest(twenty, 3)).isEqualTo(15);
        assertThat(kThSmallestNumberInBST.kthSmallest(twenty, 4)).isEqualTo(20);
    }
}