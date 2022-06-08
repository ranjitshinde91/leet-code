package other.add_2_numbers;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode lastNode = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int value;
            if (l1 == null) {
                value = carry + l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                value = carry + l1.val;
                l1 = l1.next;
            } else {
                value = carry + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode newNode;
            if (value > 9) {
                newNode = new ListNode(value % 10);
                carry = 1;
            } else {
                newNode = new ListNode(value);
                carry = 0;
            }
            if (firstNode == null) {
                firstNode = newNode;
            } else {
                lastNode.next = newNode;
            }
            lastNode = newNode;
        }

        if (carry == 1) {
            lastNode.next = new ListNode(1);
        }
        return firstNode;

    }
}