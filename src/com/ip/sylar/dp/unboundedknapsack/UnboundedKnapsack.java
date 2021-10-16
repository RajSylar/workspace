package com.ip.sylar.dp.unboundedknapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(unboundedKnapsack(wt, val, W, n));
    }

    private static int unboundedKnapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][W];
    }

    private static int unboundedKnapsackRecur(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + unboundedKnapsack(wt, val, W - wt[n - 1], n), unboundedKnapsack(wt, val, W, n - 1));
        } else {
            return unboundedKnapsack(wt, val, W, n - 1);
        }
    }
}
