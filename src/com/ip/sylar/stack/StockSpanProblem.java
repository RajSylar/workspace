package com.ip.sylar.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    static class Pair {
        private int ngv;
        private int index;

        public Pair(int ngv, int index) {
            this.ngv = ngv;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        fetchStockSpan(arr, n, list);
//        List<Integer> list2 = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            list2.add(i - list.get(i));
//        }
        System.out.println(list);
    }

    private static void fetchStockSpan(int[] arr, int n, List<Integer> list) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                list.add(i-(-1));
            } else if (!stack.isEmpty() && stack.peek().ngv > arr[i]) {
                list.add(i- stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().ngv <= arr[i]) {
                while (!stack.isEmpty() && stack.peek().ngv <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    list.add(i-(-1));
                else
                    list.add(i-stack.peek().index);
            }
            stack.push(new Pair(arr[i], i));
        }
    }
}
