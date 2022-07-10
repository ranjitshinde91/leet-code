package tree.maximum_sum_of_non_adjacent_nodes;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeFixture.buildTree;

class MaximumSumOfNonAdjacentNodesTest {
    @Test
    void name() {

        Node node = buildTree("26 54 8 90 97 69 60 77 35 7 31 89 17 47 69 77 54 62 55 67 47 67 50 81 97 18 21 8 22 16 38 100 90 95 27 13 N 21 33 81 29 79 32 9 93 27 44 10 61 82 64 51 49 93 71 16 78 59 43 47 6 92 45 14 84 36 91 16 35 5 58 87 50 N 76 75 84");

        var maximumSumOfNonAdjacentNodes = new MaximumSumOfNonAdjacentNodes();

        int maxSum = maximumSumOfNonAdjacentNodes.getMaxSum(node);

        assertThat(maxSum).isEqualTo(2655);
    }

}