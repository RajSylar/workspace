package com.ip.sylar.dp.binaryKnapsack;

public class KnapsackProblemMemoized {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        int t[][] = new int[n + 1][W + 1];
        initialize(t);
        System.out.println(knapsackMemoized(wt, val, W, n, t));
    }

    private static void initialize(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }
    }

    private static int knapsackMemoized(int[] wt, int[] val, int W, int n, int[][] t) {
        if (n == 0 || W == 0)
            return 0;

        if (t[n][W] != -1)
            return t[n][W];

        if (wt[n - 1] <= W) {
            t[n][W] = Math.max(val[n - 1] + knapsackMemoized(wt, val, W - wt[n - 1], n - 1, t), knapsackMemoized(wt, val, W, n - 1, t));
        } else {
            t[n][W] = knapsackMemoized(wt, val, W, n - 1, t);
        }
        return t[n][W];
    }
}
