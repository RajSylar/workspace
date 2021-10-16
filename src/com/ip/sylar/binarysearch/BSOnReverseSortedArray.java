package com.ip.sylar.binarysearch;

public class BSOnReverseSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        int target = 2;
        int n = arr.length;
        System.out.println(binarySearchReverseIterative(arr, n, target));

        System.out.println(binarySearchReverseUtil(arr, n, target));

    }

    private static int binarySearchReverseUtil(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        return binarySearchReverseRecursive(arr, low, high, target);
    }

    private static int binarySearchReverseRecursive(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchReverseRecursive(arr, low, mid - 1, target);
            } else {
                return binarySearchReverseRecursive(arr, mid + 1, high, target);
            }
        }
        return -1;
    }

    private static int binarySearchReverseIterative(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
