package nth_node_from_the_end_of_list;


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode nodeToRemove = head;
        ListNode previousNodeOfNodeToRemove = head;

        ListNode startingNode = head;
        for (int i = 0; i < n; i++) {
            startingNode = startingNode.next;
        }

        while (startingNode != null) {
            startingNode = startingNode.next;
            previousNodeOfNodeToRemove = nodeToRemove;
            nodeToRemove = nodeToRemove.next;
        }

        if (nodeToRemove == head) {
            //probable dangling pointer
            return nodeToRemove.next;
        }
        previousNodeOfNodeToRemove.next = nodeToRemove.next;
        return head;
    }
}