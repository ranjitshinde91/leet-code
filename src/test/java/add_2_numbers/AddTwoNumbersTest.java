package add_2_numbers;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {

    @Test
    void shouldAddTwoZeros() {
        Solution solution = new Solution();
        var l1 = new ListNode(0);
        var l2 = new ListNode(0);

        var listNode = solution.addTwoNumbers(l1, l2);

        assertThat(listNode.val).isEqualTo(0);
        assertThat(listNode.next).isNull();
    }

    @Test
    void shouldAddTwoNumbers() {
        Solution solution = new Solution();
        var l13 = new ListNode(3);
        var l12 = new ListNode(4, l13);
        var l11 = new ListNode(2, l12);

        var l23 = new ListNode(4);
        var l22 = new ListNode(6, l23);
        var l21 = new ListNode(5, l22);

        var listNode = solution.addTwoNumbers(l11, l21);

        assertThat(listNode.val).isEqualTo(7);
        assertThat(listNode.next.val).isEqualTo(0);
        assertThat(listNode.next.next.val).isEqualTo(8);
    }

    @Test
    void shouldAddTwoNonZeroNumber() {
        Solution solution = new Solution();
        var l17 = new ListNode(9);
        var l16 = new ListNode(9, l17);
        var l15 = new ListNode(9, l16);
        var l14 = new ListNode(9, l15);
        var l13 = new ListNode(9, l14);
        var l12 = new ListNode(9, l13);
        var l11 = new ListNode(9, l12);

        var l24 = new ListNode(9);
        var l23 = new ListNode(9, l24);
        var l22 = new ListNode(9, l23);
        var l21 = new ListNode(9, l22);

        var listNode = solution.addTwoNumbers(l11, l21);

        assertThat(listNode.val).isEqualTo(8);
        assertThat(listNode.next.val).isEqualTo(9);
        assertThat(listNode.next.next.val).isEqualTo(9);
        assertThat(listNode.next.next.next.val).isEqualTo(9);
        assertThat(listNode.next.next.next.next.val).isEqualTo(0);
        assertThat(listNode.next.next.next.next.next.val).isEqualTo(0);
        assertThat(listNode.next.next.next.next.next.next.val).isEqualTo(0);
        assertThat(listNode.next.next.next.next.next.next.next.val).isEqualTo(1);

    }
}