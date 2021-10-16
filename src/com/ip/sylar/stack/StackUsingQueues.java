package com.ip.sylar.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    private void push(int data) {
        q2.add(data);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    private int pop() {
        if (!q1.isEmpty()) {
            int data = q1.remove();
            return data;
        }
        return -1;
    }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();
        System.out.println(s.pop());
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
