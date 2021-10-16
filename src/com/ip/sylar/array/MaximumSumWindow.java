package com.ip.sylar.array;

public class MaximumSumWindow {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 2;
        int n = arr.length;
        System.out.println(windowMaxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {
        int maxSum = 0;
        int currentSum = 0;
        if (n < k) {
            return -1;
        }
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + arr[i];
        }

        currentSum = maxSum;
        for (int i = k; i < n; i++) {
            currentSum = currentSum + arr[i] - arr[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    private static int maxSumForWindow(int[] arr, int n, int k) {
        int maxSum = 0;
        int currentSum = 0;
        if (n < k) {
            return -1;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < k) {
                currentSum = currentSum + arr[i];
                j++;
                continue;
            }
            maxSum = currentSum;

            currentSum = currentSum + arr[i] - arr[i - k];

            if (maxSum < currentSum)
                maxSum = currentSum;
        }
        return maxSum;
    }

    private static int windowMaxSum(int[] arr, int n, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int j = 0;
        int i = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (j - i + 1 <= k) {
                j++;
            } else {
                sum = sum -arr[i];
                maxSum = Math.max(maxSum, sum);
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
