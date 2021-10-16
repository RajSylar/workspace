package com.ip.sylar.dp.binaryKnapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 11, 5};
        int n = arr.length;

        System.out.println(isEqualSumPartitionExist(arr, n));
    }

    private static boolean isEqualSumPartitionExist(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0)
            return false;
        else {
            //return canPartition(arr);
            return findSubsetSumProblem(arr, sum / 2, n);
        }
    }

    private static boolean findSubsetSumProblem(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n ; i++)
        {
            sum = sum + nums[i];
        }
        if(sum %2 !=0)
            return false;
        else
            return isSubsetExist(nums, sum/2, n);
    }

    public static boolean isSubsetExist(int[] nums, long sum, int n)
    {
        if(n==0 && sum != 0)
            return false;
        if(sum == 0)
            return true;

        if(nums[n-1] <= sum)
        {
            return (isSubsetExist(nums, sum-nums[n-1], n-1) || isSubsetExist(nums, sum, n-1));
        }
        else
            return isSubsetExist(nums, sum, n-1);
    }
}
