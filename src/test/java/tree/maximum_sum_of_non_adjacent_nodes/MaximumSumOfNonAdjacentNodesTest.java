package tree.maximum_sum_of_non_adjacent_nodes;

import org.junit.jupiter.api.Test;
import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSumOfNonAdjacentNodesTest {
    @Test
    void name() {

        Node node = buildTree("26 54 8 90 97 69 60 77 35 7 31 89 17 47 69 77 54 62 55 67 47 67 50 81 97 18 21 8 22 16 38 100 90 95 27 13 N 21 33 81 29 79 32 9 93 27 44 10 61 82 64 51 49 93 71 16 78 59 43 47 6 92 45 14 84 36 91 16 35 5 58 87 50 N 76 75 84");

        var maximumSumOfNonAdjacentNodes = new MaximumSumOfNonAdjacentNodes();

        int maxSum = maximumSumOfNonAdjacentNodes.getMaxSum(node);

        assertThat(maxSum).isEqualTo(2655);
    }


    static Node buildTree(String str) {
        if (str.length() == 0 | str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i > ip.length) {
                break;
            }
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

}