package com.ip.sylar.linkedList;

public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);

        ListNode rest = addTwoNumbers(l1, l2);

        printList(rest);
    }

    private static void printList(ListNode rest) {

        while (rest != null) {
            System.out.println(rest.val);
            rest = rest.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode x = null;
        int carry = 0;
        ListNode temp = x;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            if (sum >= 10) {
                int rem = sum % 10;
                if (x == null) {
                    x = new ListNode(rem);
                    temp = x;
                } else {
                    ListNode newNode = new ListNode(rem);
                    temp.next = newNode;
                    temp = newNode;
                }
                carry = 1;
            } else {
                if (x == null) {
                    x = new ListNode(sum);
                    temp = x;
                } else {
                    ListNode newNode = new ListNode(sum);
                    temp.next = newNode;
                    temp = newNode;
                }
                carry = 0;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = (curr1.val + carry);
            if (sum >= 10) {
                int rem = sum % 10;
                ListNode newNode = new ListNode(rem);
                temp.next = newNode;
                temp = newNode;
                curr1 = curr1.next;
                carry = 1;
            } else {
                ListNode newNode = new ListNode(sum);
                temp.next = newNode;
                temp = newNode;
                curr1 = curr1.next;
                carry = 0;
            }
        }

        while (curr2 != null) {
            int sum = (curr2.val + carry);
            if (sum >= 10) {
                int rem = sum % 10;
                ListNode newNode = new ListNode(rem);
                temp.next = newNode;
                temp = newNode;
                curr2 = curr2.next;
                carry = 1;
            } else {
                ListNode newNode = new ListNode(sum);
                temp.next = newNode;
                temp = newNode;
                curr2 = curr2.next;
                carry = 0;
            }
        }

        if (carry == 1) {
            ListNode n = new ListNode(carry);
            temp.next = n;
            carry = 0;
            temp = n;
        }
        return x;

    }
}
