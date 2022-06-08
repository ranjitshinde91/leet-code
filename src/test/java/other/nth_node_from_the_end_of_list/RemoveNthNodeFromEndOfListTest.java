package other.nth_node_from_the_end_of_list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void test1() {
        var solution = new Solution();
        ListNode one = new ListNode(1);

        ListNode root = solution.removeNthFromEnd(one, 1);

        assertThat(root).isNull();
    }

    @Test
    void test2() {
        var solution = new Solution();
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);

        ListNode root = solution.removeNthFromEnd(one, 1);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next).isNull();
    }

    @Test
    void test3() {
        var solution = new Solution();
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);

        ListNode root = solution.removeNthFromEnd(one, 2);

        assertThat(root.val).isEqualTo(2);
        assertThat(root.next).isNull();
    }

    @Test
    void test4() {

        var solution = new Solution();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode root = solution.removeNthFromEnd(one, 2);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.next.val).isEqualTo(2);
        assertThat(root.next.next.val).isEqualTo(3);
        assertThat(root.next.next.next.val).isEqualTo(5);
        assertThat(root.next.next.next.next).isNull();
    }
}