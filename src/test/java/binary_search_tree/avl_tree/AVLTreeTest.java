package binary_search_tree.avl_tree;

import binary_search_tree.BinaryTreePrinter;
import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class AVLTreeTest {

    @Test
    void llRotation() {
        AVLTree avlTree = new AVLTree(30);
        avlTree.insert(20);
        avlTree.insert(10);

        Node root = avlTree.root();

        BinaryTreePrinter.printNode(root);
        assertThat(root.data).isEqualTo(20);
        assertThat(root.left.data).isEqualTo(10);
        assertThat(root.right.data).isEqualTo(30);
    }

    @Test
    void RRRotation() {
        AVLTree avlTree = new AVLTree(10);
        avlTree.insert(20);
        avlTree.insert(30);

        Node root = avlTree.root();

        BinaryTreePrinter.printNode(root);
        assertThat(root.data).isEqualTo(20);
        assertThat(root.left.data).isEqualTo(10);
        assertThat(root.right.data).isEqualTo(30);
    }

    @Test
    void lRRotation() {
        AVLTree avlTree = new AVLTree(50);
        avlTree.insert(60);
        avlTree.insert(20);
        avlTree.insert(10);
        avlTree.insert(40);
        avlTree.insert(30);
        avlTree.insert(45);

        Node root = avlTree.root();

        BinaryTreePrinter.printNode(root);
        assertThat(root.data).isEqualTo(40);
        assertThat(root.left.data).isEqualTo(20);
        assertThat(root.right.data).isEqualTo(50);
    }

    @Test
    void RLRotation() {
        AVLTree avlTree = new AVLTree(20);
        avlTree.insert(10);
        avlTree.insert(50);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(30);
        avlTree.insert(45);

        Node root = avlTree.root();

        BinaryTreePrinter.printNode(root);
        assertThat(root.data).isEqualTo(40);
        assertThat(root.left.data).isEqualTo(20);
        assertThat(root.right.data).isEqualTo(50);
    }

    @Test
    void delete() {
        AVLTree avlTree = new AVLTree(20);
        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(40);

        BinaryTreePrinter.printNode(avlTree.root());
        avlTree.delete(10);
        BinaryTreePrinter.printNode(avlTree.root());

        assertThat(avlTree.root().data).isEqualTo(30);
        assertThat(avlTree.root().left.data).isEqualTo(20);
        assertThat(avlTree.root().right.data).isEqualTo(40);
    }
}