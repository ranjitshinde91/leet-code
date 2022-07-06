package tree.serialize_and_deserialize_a_binary_tree;

import org.junit.jupiter.api.Test;
import tree.Node;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class SerializeAndDeserializeABinaryTreeTest {

    @Test
    void test() {
        var three = new Node(3);
        var nine = new Node(9);
        var twenty = new Node(20);
        var fifteen = new Node(15);
        var seven = new Node(7);

        twenty.left = fifteen;
        twenty.right = seven;

        three.left = nine;
        three.right = twenty;

        var solution = new SerializeAndDeserializeABinaryTree();

        ArrayList<Integer> list = new ArrayList<>();
        solution.serialize(three, list);

        assertThat(list).containsExactly(3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1);

        Node node = solution.deSerialize(list);

        assertThat(node.data).isEqualTo(3);
        assertThat(node.left.data).isEqualTo(9);
        assertThat(node.right.data).isEqualTo(20);

        assertThat(node.left.left).isNull();
        assertThat(node.left.right).isNull();

        assertThat(node.right.left.data).isEqualTo(15);
        assertThat(node.right.right.data).isEqualTo(7);

        assertThat(node.right.left.left).isNull();
        assertThat(node.right.left.right).isNull();

        assertThat(node.right.right.left).isNull();
        assertThat(node.right.right.right).isNull();

    }

}