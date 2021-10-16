package com.ip.sylar.dp.binaryKnapsack;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 11, 5};
        int n = arr.length;
        System.out.println(findMinimumSubsetSumDiff(arr, n));
    }

    private static int findMinimumSubsetSumDiff(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        List<Integer> list = findSubsetSumVector(arr, n, sum);

        int min = Integer.MAX_VALUE;

        for (int i : list) {
            min = Math.min(min, Math.abs(sum - 2*i));
        }
        return min;
    }

    private static List<Integer> findSubsetSumVector(int[] arr, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < (sum + 1); j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j <= (sum + 1)/2; j++) {
            if (t[n][j] == true)
                list.add(j);
        }

        return list;
    }
}
