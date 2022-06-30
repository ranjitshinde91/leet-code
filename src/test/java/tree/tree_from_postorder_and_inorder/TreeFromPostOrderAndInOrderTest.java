package tree.tree_from_postorder_and_inorder;

import org.junit.jupiter.api.Test;
import tree.TreeNode;
import tree.level_order_traversal.LevelOrderTraversal;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreeFromPostOrderAndInOrderTest {

    @Test
    void treeFromPostOrderAndInOrder() {
        TreeFromPostOrderAndInOrder treeFromPostOrderAndInOrder = new TreeFromPostOrderAndInOrder();

        int[] in = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = new int[]{8, 4, 5, 2, 6, 7, 3, 1};

        TreeNode treeNode = treeFromPostOrderAndInOrder.buildTree(in, post, in.length);

        assertThat(levelOrderTraversal(treeNode)).containsExactlyElementsOf(
                List.of(
                        List.of(1),
                        List.of(2, 3),
                        List.of(4, 5, 6, 7),
                        List.of(8)
                )
        );
    }

    private List<List<Integer>> levelOrderTraversal(TreeNode treeNode) {
        var solution = new LevelOrderTraversal();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        return lists;
    }
}