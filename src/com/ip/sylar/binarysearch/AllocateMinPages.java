package com.ip.sylar.binarysearch;

public class AllocateMinPages {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,1};
        int n = arr.length;
        int k = 4;

        System.out.println(findMinAllocation(arr, n, k));
    }

    private static int findMinAllocation(int[] arr, int n, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(max < arr[i])
                max = arr[i];
            sum = sum + arr[i];
        }

        int low = max;
        int high = sum;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, n, k, mid) == true) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int n, int k, int max) {
        int student = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];

            if (sum > max) {
                student++;
                sum = arr[i];
            }

            if (student > k)
                return false;
        }
        return true;
    }
}
