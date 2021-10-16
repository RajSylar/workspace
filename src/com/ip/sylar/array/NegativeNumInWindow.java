package com.ip.sylar.array;

import java.util.LinkedList;
import java.util.Queue;

public class NegativeNumInWindow {
    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 0, 20};
        int k = 3;
        int n = arr.length;
        firstNegInWindow(arr, n, k);
    }

    private static void negativeNumberInWindow(int[] arr, int n, int k) {
        int firstNegative = 0;
        int j = 0;
        int i = 0;
        while (j < n) {
            if (j - i + 1 <= k) {
                j++;
            } else {
                findFirstNegative(arr, i, j);
                i++;
                j++;
            }
        }
    }

    private static void findFirstNegative(int[] arr, int i, int j) {
        for (int x = i; x <= j; x++) {
            if (arr[x] < 0) {
                System.out.println(arr[x]);
                break;
            }
        }
    }

    private static void firstNegInWindow(int[] arr, int n, int k) {
        //int arr[] = {12, -1, -7, 8, -15, 30, 16, 0, 20};
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else {
                if (!queue.isEmpty()) {
                    if (arr[i] == queue.peek()) {
                        System.out.println(queue.poll());
                    } else {
                        System.out.println(queue.peek());
                    }
                }
                i++;
                j++;
            }
        }
    }
}
