package com.ip.sylar.queue;

public class QueueUsingLinkedList {

    Node front;
    Node rear;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    private void enqueue(int data) {
        Node node = new Node(data);
        if (front == null && rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    private void dequeue() {
        if (front == null && rear == null) {
            System.out.println("underflow condition");
        } else {
            front = front.next;
        }
        if (front == null) {
            this.rear = null;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        //queue.enqueue(4);
        queue.dequeue();
    }
}
