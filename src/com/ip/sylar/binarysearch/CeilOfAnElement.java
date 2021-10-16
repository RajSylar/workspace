package com.ip.sylar.binarysearch;

public class CeilOfAnElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 8, 9, 11, 13, 15};
        int n = arr.length;
        int target = 14;
        System.out.println(findCeilOfElement(arr, n, target));
    }

    private static int findCeilOfElement(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                res = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
