package com.ip.sylar.array;

import java.util.Arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(findMaxSum(arr, arr.length));
    }

    private static int findMaxSum(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            currentSum = currentSum + arr[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
