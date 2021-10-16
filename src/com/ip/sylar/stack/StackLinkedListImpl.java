package com.ip.sylar.stack;

public class StackLinkedListImpl {

    private Node top;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public StackLinkedListImpl() {
        this.top = null;
    }

    public void push(int data) {
        Node temp = new Node(data);
        if (top == null) {
            top = temp;
            return;
        } else {
            temp.next = top;
            top = temp;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("underflow condition");
            return -1;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    public static void main(String[] args) {
        StackLinkedListImpl stack = new StackLinkedListImpl();
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(12);
        stack.push(54);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
