package com.ip.sylar.dp.binaryKnapsack;

public class CountSubsetOfGivenDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,1};
        int diff = 2;
        System.out.println(findCountOfGivenDiff(arr, diff));
        //System.out.println(findTargetSumWays(arr, diff));
    }

    private static int findCountOfGivenDiff(int[] arr, int diff) {
        int n = arr.length;
        if(n<2)
            return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if(diff>sum)
            return 0;
        int targetSum = (sum + diff) / 2;

        return findSubsetCount(arr, n, targetSum);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            sum = sum + nums[i];
        }

        int targetSum = (sum + target)/2;

        return findCountOfSumWays(nums, targetSum, n);
    }

    private static int findSubsetCount(int[] arr, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    public static int findCountOfSumWays(int[] nums, int sum, int n)
    {
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(nums[i-1]<=j)
                {
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
