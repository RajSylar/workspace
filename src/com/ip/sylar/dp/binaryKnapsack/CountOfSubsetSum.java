package com.ip.sylar.dp.binaryKnapsack;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 8, 10};
        int n = arr.length;
        int sum = 10;
        System.out.println(findCountOfSubsetSumRec(arr, sum, n));
    }

    public static int findCountOfSubsetSumRec(int[] arr, int sum, int n) {
        if (n == 0 && sum != 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }

        if (arr[n - 1] <= sum) {
            return findCountOfSubsetSumRec(arr, sum - arr[n - 1], n - 1) + findCountOfSubsetSumRec(arr, sum, n - 1);
        } else {
            return findCountOfSubsetSumRec(arr, sum, n - 1);
        }
    }

    public static int findCountOfSubsetSum(int[] arr, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
