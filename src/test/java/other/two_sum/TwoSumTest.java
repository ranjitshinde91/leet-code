package other.two_sum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    @Test
    void test1() {
        var solution = new Solution();

        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertThat(ints[0]).isEqualTo(0);
        assertThat(ints[1]).isEqualTo(1);
    }

    @Test
    void test2() {
        var solution = new Solution();

        int[] ints = solution.twoSum(new int[]{3, 2, 4}, 6);

        assertThat(ints[0]).isEqualTo(1);
        assertThat(ints[1]).isEqualTo(2);
    }

    @Test
    void test3() {
        var solution = new Solution();

        int[] ints = solution.twoSum(new int[]{3, 3}, 6);

        assertThat(ints[0]).isEqualTo(0);
        assertThat(ints[1]).isEqualTo(1);
    }
}