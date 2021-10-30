package com.ip.sylar.linkedList;

public class SortLInkedList {

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode()
        {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = getMiddleNode(head);
        // one step to right
        ListNode next = right.next;
        right.next = null;
        right = next;

        left = sortList(left);
        right = sortList(right);

        return mergeList(left, right);
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode merged = new ListNode();
        ListNode tail = merged;

        while (right != null && left != null) {
            if (right.val > left.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (right == null && left != null) {
            tail.next = left;
        }

        if (left == null && right != null) {
            tail.next = right;
        }
        return merged.next;
    }
}
