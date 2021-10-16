package com.ip.sylar.dp.binaryKnapsack;

public class SubsetSumRecursion {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 24;
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        System.out.println(isSubsetDP(arr, sum, n, t));

        initialize(t);

        System.out.println(isSubsetSumPresent(arr, sum, n));

        System.out.println(isSubsetSumPresentMemoized(arr, sum, n, t));


    }

    private static boolean isSubsetDP(int[] arr, int sum, int n, boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    private static void initialize(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = false;
            }
        }
    }

    private static boolean isSubsetSumPresent(int[] arr, int sum, int n) {

        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        if (arr[n - 1] <= sum) {
            return (isSubsetSumPresent(arr, sum - arr[n - 1], n - 1) || isSubsetSumPresent(arr, sum, n - 1));
        } else {
            return (isSubsetSumPresent(arr, sum, n - 1));
        }
    }

    private static boolean isSubsetSumPresentMemoized(int[] arr, int sum, int n, boolean[][] t) {

        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum == 0) {
            t[n][sum] = true;
            return t[n][sum];
        }

        if (t[n][sum] != false)
            return t[n][sum];

        if (arr[n - 1] <= sum) {
            t[n][sum] = (isSubsetSumPresent(arr, sum - arr[n - 1], n - 1) || isSubsetSumPresent(arr, sum, n - 1));
            return t[n][sum];
        } else {
            t[n][sum] = (isSubsetSumPresent(arr, sum, n - 1));
            return t[n][sum];
        }
    }
}
