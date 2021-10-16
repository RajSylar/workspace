package com.ip.sylar.queue;

import java.util.Stack;

/*
   By making dequeue operation coslty
 */
public class QueueByTwoStacks {
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    private void enqueue(int data) {
        firstStack.push(data);
    }

    private int dequeue() {
        if (firstStack.isEmpty() && secondStack.isEmpty()) {
            return -1;
        }
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }

        int data = secondStack.pop();
        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
        return data;
    }

    public static void main(String[] args) {
        QueueByTwoStacks queue = new QueueByTwoStacks();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
