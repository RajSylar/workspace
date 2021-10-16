package com.ip.sylar.queue;

public class DequeUsingCA {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public DequeUsingCA(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    private void enqueueRear(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("overflow condition");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = data;
        } else if (rear == size - 1) {
            rear = 0;
            arr[rear] = data;
        } else {
            rear++;
            arr[rear] = data;
        }
    }

    private void enqueueFront(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("overflow condition");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[front] = data;
        } else if (front == 0) {
            front = size - 1;
            arr[front] = data;
        } else {
            front--;
            arr[front] = data;
        }
    }

    private int dequeueFront() {
        if (front == -1 && rear == -1) {
            System.out.println("underflow condition");
            return -1;
        } else if (front == rear) {
            int data = arr[front];
            front = rear = -1;
            return data;
        } else if (front == size - 1) {
            int data = arr[front];
            front = 0;
            return data;
        } else {
            int data = arr[front];
            front++;
            return data;
        }
    }

    private int dequeueRear() {
        if (front == -1 && rear == -1) {
            System.out.println("underflow condition");
            return -1;
        } else if (front == rear) {
            int data = arr[rear];
            front = rear = -1;
            return data;
        } else if (rear == 0) {
            int data = arr[rear];
            rear = size - 1;
            return data;
        } else {
            int data = arr[rear];
            rear--;
            return data;
        }
    }

    public static void main(String[] args) {
        DequeUsingCA deque = new DequeUsingCA(5);
    }
}
