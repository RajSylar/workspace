package com.ip.sylar.slidingwindow;

public class MaximumSubArraySumForWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 8, 2, 9, 1};
        int n = arr.length;
        int k = 3;

        System.out.println(findMaximumSubArraySum(arr, n, k));

        System.out.println(findMaxSubArraySumAlt(arr, n, k));
    }

    private static int findMaximumSubArraySum(int[] arr, int n, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum = currentSum + arr[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < n; i++) {
            currentSum = currentSum + arr[i] - arr[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    private static int findMaxSubArraySumAlt(int[] arr, int n, int k)
    {
        int currentSum = 0;
        int i=0;
        int j=0;
        int maxSum = Integer.MIN_VALUE;
        while(j<n)
        {
            currentSum = currentSum + arr[j];
            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                if(currentSum > maxSum)
                {
                    maxSum = currentSum;
                }
                currentSum = currentSum - arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
