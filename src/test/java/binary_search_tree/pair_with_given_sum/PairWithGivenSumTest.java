package binary_search_tree.pair_with_given_sum;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.assertj.core.api.Assertions.assertThat;

class PairWithGivenSumTest {

    @Test
    void test() {
        var three = new Node(4);
        three.left = new Node(2);
        three.right = new Node(5);

        var pairWithGivenSum = new PairWithGivenSum();

        assertThat(pairWithGivenSum.findPair(three, 6)).isTrue();
        assertThat(pairWithGivenSum.findPair(three, 8)).isFalse();
    }

}