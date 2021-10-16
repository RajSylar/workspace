package com.ip.sylar.queue;

import java.util.Stack;

public class QueueByTwoStacks2 {
    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    private void enqueue(int data) {
        if (!firstStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        firstStack.push(data);

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
    }

    private int dequeue() {
        if (!firstStack.isEmpty()) {
            return firstStack.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        QueueByTwoStacks2 queue = new QueueByTwoStacks2();
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
