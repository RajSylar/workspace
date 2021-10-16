package com.ip.sylar.heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = arr.length;

        System.out.println(findMinimumCost(arr, n));
    }

    private static int findMinimumCost(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            cost = cost + sum;

            if (!pq.isEmpty()) {
                pq.add(sum);
            }
        }
        return cost;
    }
}
