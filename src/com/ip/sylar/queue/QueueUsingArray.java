package com.ip.sylar.queue;

public class QueueUsingArray {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public QueueUsingArray(int cap) {
        this.arr = new int[cap];
        this.capacity = cap;
        front = rear = -1;
    }

    private void enqueue(int data) {
        if (rear == capacity - 1) {
            System.out.println("overflow condition");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            arr[rear] = data;
        } else {
            rear++;
            arr[rear] = data;
        }
    }

    private void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("overflow condition");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            System.out.println(arr[front]);
            front++;
        }
    }

    public static void main(String[] args) {
        QueueUsingArray queueUsingArray = new QueueUsingArray(3);
    }

}
