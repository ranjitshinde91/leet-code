package binary_search_tree.operations;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeOperationsTest {

    @Test
    void insert() {
        var three = new Node(3);
        var operations = new BinarySearchTreeOperations();

        var root = operations.insert(three, 4);
        assertThat(root.right.data).isEqualTo(4);

        root = operations.insert(three, 2);
        assertThat(root.left.data).isEqualTo(2);
    }

    @Test
    void search() {
        var three = new Node(3);
        three.left = new Node(2);
        three.right = new Node(4);

        var operations = new BinarySearchTreeOperations();

        assertThat(operations.search(three, 2)).isTrue();
        assertThat(operations.search(three, 5)).isFalse();
    }

    @Test
    void delete() {
        var three = new Node(3);
        three.left = new Node(2);
        three.right = new Node(4);

        var operations = new BinarySearchTreeOperations();

        Node root = operations.deleteNode(three, 2);

        assertThat(root.left).isNull();
    }

    @Test
    void deleteWithHeightConsideration() {
        var three = new Node(3);
        Node four = new Node(4);

        four.right = new Node(5);

        three.left = new Node(2);
        three.right = four;

        var operations = new BinarySearchTreeOperations();

        Node root = operations.deleteNode(three, 3);

        assertThat(root.data).isEqualTo(4);
        assertThat(root.left.data).isEqualTo(2);
        assertThat(root.right.data).isEqualTo(5);
    }

}