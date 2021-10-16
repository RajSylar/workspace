package com.ip.sylar.queue;

import java.util.Stack;

public class QueueByOneStack {
    Stack<Integer> stack = new Stack<>();

    private void enqueue(int data) {
        stack.push(data);
    }

    private int dequeue() {
        if (stack.isEmpty()) {
            return -1;
        }
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        int item = dequeue();
        stack.push(top);
        return item;
    }

    public static void main(String[] args) {
        QueueByOneStack queue = new QueueByOneStack();
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(2);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
