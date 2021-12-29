package partition_list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionListTest {

    @Test
    void test1() {
        var solution = new Solution();

        var root = solution.partition(null, 2);

        assertThat(root).isNull();
    }

    @Test
    void test11() {
        var one = new ListNode(1);
        var solution = new Solution();

        var root = solution.partition(one, 0);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next).isNull();
    }

    @Test
    void test12() {
        var one = new ListNode(1);
        var solution = new Solution();

        var root = solution.partition(one, 2);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next).isNull();
    }

    @Test
    void test2() {
        var one = new ListNode(1);
        var two = new ListNode(2, one);

        var solution = new Solution();

        var root = solution.partition(two, 2);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next.val).isEqualTo(2);
        assertThat(root.next.next).isNull();
    }

    @Test
    void test3() {
        var secondTwo = new ListNode(2, null);
        var five = new ListNode(5, secondTwo);
        var two = new ListNode(2, five);
        var three = new ListNode(3, two);
        var four = new ListNode(4, three);
        var one = new ListNode(1, four);

        var solution = new Solution();

        var root = solution.partition(one, 3);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next.val).isEqualTo(2);
        assertThat(root.next.next.val).isEqualTo(2);
        assertThat(root.next.next.next.val).isEqualTo(4);
        assertThat(root.next.next.next.next.val).isEqualTo(3);
        assertThat(root.next.next.next.next.next.val).isEqualTo(5);
        assertThat(root.next.next.next.next.next.next).isNull();
    }

    @Test
    void test4() {
        var secondTwo = new ListNode(2, null);
        var five = new ListNode(5, secondTwo);
        var two = new ListNode(2, five);
        var three = new ListNode(3, two);
        var four = new ListNode(4, three);
        var one = new ListNode(1, four);

        var solution = new Solution();

        var root = solution.partition(one, 2);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next.val).isEqualTo(4);
        assertThat(root.next.next.val).isEqualTo(3);
        assertThat(root.next.next.next.val).isEqualTo(2);
        assertThat(root.next.next.next.next.val).isEqualTo(5);
        assertThat(root.next.next.next.next.next.val).isEqualTo(2);
        assertThat(root.next.next.next.next.next.next).isNull();
    }
}