package com.ip.sylar.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class NegativeNumberInWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 0, 20};
        int n = arr.length;
        int k = 3;

        findFirstNegativeNumberInWindow(arr, n, k);
    }

    private static void findFirstNegativeNumberInWindow(int[] arr, int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (!queue.isEmpty()) {
                    if (arr[i] == queue.peek()) {
                        System.out.println(queue.poll());
                    } else {
                        System.out.println(queue.peek());
                    }
                } else {
                    System.out.println("No negative number in this window");
                }
                i++;
                j++;
            }
        }
    }
}
