package com.ip.sylar.queue;

public class QueueArray {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.capacity = size;
        front = 0;
        rear = -1;
        size = 0;
    }

    private boolean isFull() {
        return this.size == this.capacity;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void enqueue(int data) {
        if (isFull()) {
            System.out.println("Overflow condition");
            return;
        }
        this.rear = (this.rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    private int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow condition");
            return -1;
        }
        int data = arr[front];
        this.front = (this.front + 1) % capacity;
        size--;
        System.out.println(data);
        return data;
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        queueArray.dequeue();
        queueArray.enqueue(2);
        queueArray.enqueue(4);
        queueArray.enqueue(5);
        queueArray.enqueue(32);
        queueArray.enqueue(31);

        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        System.out.println(queueArray.isEmpty());
        for (int i = 0; i < queueArray.arr.length; i++) {
            System.out.println(queueArray.arr[i]);
        }
        //queueArray.enqueue(35);
    }
}
