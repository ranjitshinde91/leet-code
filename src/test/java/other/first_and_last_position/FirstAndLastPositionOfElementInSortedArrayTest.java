package other.first_and_last_position;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    void test1() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{}, 0);

        assertThat(positions[0]).isEqualTo(-1);
        assertThat(positions[1]).isEqualTo(-1);
    }

    @Test
    void test2() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{1}, 1);

        assertThat(positions[0]).isEqualTo(0);
        assertThat(positions[1]).isEqualTo(0);
    }

    @Test
    void test3() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{1}, 2);

        assertThat(positions[0]).isEqualTo(-1);
        assertThat(positions[1]).isEqualTo(-1);
    }

    @Test
    void test4() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{1, 3}, 1);

        assertThat(positions[0]).isEqualTo(0);
        assertThat(positions[1]).isEqualTo(0);
    }

    @Test
    void test5() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{1, 3}, 3);

        assertThat(positions[0]).isEqualTo(1);
        assertThat(positions[1]).isEqualTo(1);
    }

    @Test
    void test6() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{3, 3}, 3);

        assertThat(positions[0]).isEqualTo(0);
        assertThat(positions[1]).isEqualTo(1);
    }

    @Test
    void test7() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{3, 3, 3}, 3);

        assertThat(positions[0]).isEqualTo(0);
        assertThat(positions[1]).isEqualTo(2);
    }

    @Test
    void test8() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5}, 3);

        assertThat(positions[0]).isEqualTo(4);
        assertThat(positions[1]).isEqualTo(8);
    }

    @Test
    void test9() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);

        assertThat(positions[0]).isEqualTo(-1);
        assertThat(positions[1]).isEqualTo(-1);
    }

    @Test
    void test10() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

        assertThat(positions[0]).isEqualTo(3);
        assertThat(positions[1]).isEqualTo(4);
    }

    @Test
    void test11() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10, 12, 14, 14}, 14);

        assertThat(positions[0]).isEqualTo(7);
        assertThat(positions[1]).isEqualTo(8);
    }

    @Test
    void test12() {
        var solution = new Solution();

        int[] positions = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10, 12, 14, 14}, 5);

        assertThat(positions[0]).isEqualTo(0);
        assertThat(positions[1]).isEqualTo(0);
    }

}