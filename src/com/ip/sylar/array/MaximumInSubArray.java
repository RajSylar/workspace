package com.ip.sylar.array;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumInSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int window = 3;
        maxInSubArray(arr, arr.length, window);
    }

    private static void maxInSubArray(int[] arr, int n, int k) {
        int i = 0;
        int j = 0;

        Queue<Integer> queue = new LinkedList<>();

        while (j < n) {
            while (!queue.isEmpty() && queue.peek() < arr[j]) {
                queue.remove();
            }
            queue.add(arr[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                System.out.println(queue.peek());
                if (arr[i] == queue.peek()) {
                    queue.remove();
                }
                i++;
                j++;
            }
        }
    }
}
