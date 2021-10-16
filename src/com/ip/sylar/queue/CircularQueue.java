package com.ip.sylar.queue;

public class CircularQueue {
    private int front;
    private int rear;
    private int[] arr;
    private int size;

    public CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    private void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("queue is full");
            return;
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = data;
        } else {
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
    }

    private void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("queue is empty");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            int temp = arr[front];
            front = (front + 1) % size;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(32);
        queue.enqueue(12);
        queue.enqueue(5);
    }
}
