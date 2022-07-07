package binary_search_tree.floor_in_bst;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class FloorInBSTTest {

    @Test
    void test() {
        var three = new Node(4);
        three.left = new Node(2);
        three.right = new Node(5);

        var floorInBST = new FloorInBST();

        assertThat(floorInBST.floor(three, 1)).isEqualTo(-1);
        assertThat(floorInBST.floor(three, 6)).isEqualTo(5);
        assertThat(floorInBST.floor(three, 3)).isEqualTo(2);

    }
}