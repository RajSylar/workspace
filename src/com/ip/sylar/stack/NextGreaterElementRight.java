package com.ip.sylar.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementRight {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        findNextGreaterElement(arr, n, list);
        Collections.reverse(list);
        System.out.println(list);
    }

    private static void findNearestSmallerToRight(int[] arr, int n, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.empty()) {
                list.add(-1);
            } else if (!stack.empty() && stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.empty())
                    list.add(-1);
                else
                    list.add(stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    private static void findNearestSmallestToLeft(int[] arr, int n, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.empty() && stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (!stack.empty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    list.add(-1);
                else
                    list.add(stack.peek());
            }

            stack.push(arr[i]);
        }
    }

    private static void findNextGreaterLeft(int[] arr, int n, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.empty() && stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else if (!stack.empty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
    }

    private static void findNextGreaterElement(int[] arr, int n, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.empty() && stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else if(!stack.empty() && stack.peek() <= arr[i]) {
                while (stack.size()>0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    list.add(-1);
                else
                    list.add(stack.peek());
            }
            stack.push(arr[i]);
        }
    }
}
