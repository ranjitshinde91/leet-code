package other.partition_list;

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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lessNodes = null;
        ListNode graterOrEqualNodes = null;
        ListNode startNodeOfNewList = null;
        ListNode startNodeOfGreaterOrEqualList = null;

        ListNode traversalNode = head;

        while (traversalNode != null) {
            int value = traversalNode.val;
            if (value < x) {
                if (startNodeOfNewList == null) {
                    startNodeOfNewList = traversalNode;
                }
                if (lessNodes == null) {
                    lessNodes = traversalNode;
                } else {
                    lessNodes.next = traversalNode;
                    lessNodes = lessNodes.next;
                }
            } else {
                if (startNodeOfGreaterOrEqualList == null) {
                    startNodeOfGreaterOrEqualList = traversalNode;
                }
                if (graterOrEqualNodes == null) {
                    graterOrEqualNodes = traversalNode;
                } else {
                    graterOrEqualNodes.next = traversalNode;
                    graterOrEqualNodes = graterOrEqualNodes.next;
                }
            }
            traversalNode = traversalNode.next;
        }
        if (startNodeOfNewList == null) {
            return startNodeOfGreaterOrEqualList;
        }
        lessNodes.next = startNodeOfGreaterOrEqualList;
        if (graterOrEqualNodes != null) {
            graterOrEqualNodes.next = null;
        }
        return startNodeOfNewList;
    }
}
