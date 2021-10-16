package com.ip.sylar.leetcode;

public class maxSubArray {
    public static int maxSubArrayPlain(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j <= nums.length - 1; j++) {
                sum = sum + nums[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int maxSumArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            currentSum = currentSum + arr[i];
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static int maxSubArraySum(int[] arr)
    {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for(int i=0; i<arr.length; i++)
        {
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(nums));
    }
}
