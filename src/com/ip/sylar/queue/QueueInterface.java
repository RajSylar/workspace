package com.ip.sylar.queue;

import java.util.*;

public class QueueInterface {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(1);
        queue.clear();
        queue.add(3);
        queue.add(4);
        queue.offer(54);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
