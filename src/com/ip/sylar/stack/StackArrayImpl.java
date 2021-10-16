package com.ip.sylar.stack;

public class StackArrayImpl {

    private int[] arr;
    private int size;
    private int top;

    public StackArrayImpl(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    private boolean isFull() {
        return top == size - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void push(int data) {
        if (isFull()) {
            System.out.println("overflow condition");
        } else {
            top++;
            arr[top] = data;
        }
    }

    private int pop() {
        if (isEmpty()) {
            System.out.println("underflow condition");
            return -1;
        } else {
            int temp = arr[top];
            top--;
            return temp;
        }
    }

    public static void main(String[] args) {
        StackArrayImpl stack = new StackArrayImpl(4);
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
