package com.ip.sylar.queue;

public class CircularQueueLL {

    private Node front;
    private Node rear;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public CircularQueueLL() {
        this.front = null;
        this.rear = null;
    }

    private void enqueue(int data) {
        Node node = new Node(data);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        rear.next = front;
    }

    private void dequeue() {
        Node temp = front;
        if (front == null) {
            System.out.println("underflow condition");
        } else if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
    }

    public static void main(String[] args) {
        CircularQueueLL queueLL = new CircularQueueLL();
        queueLL.enqueue(3);
        queueLL.dequeue();
        queueLL.dequeue();
    }
}
