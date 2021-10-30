package com.ip.sylar.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchPlain {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 9, 12, 15, 32};
        int target = 12;
        int n = arr.length;
        System.out.println(binarySearchIterative(arr, n, target));

        System.out.println(binarySearchUtil(arr, n, target));

    }

    private static int binarySearchIterative(int[] arr, int n, int target) {
        int start = 0;
        int end = n - 1;

        List<Integer> list = new ArrayList<>();
        int x = list.get(list.size()-1);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchUtil(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        return binarySearchRecursive(arr, low, high, target);
    }

    private static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearchRecursive(arr, low, mid - 1, target);
            } else {
                return binarySearchRecursive(arr, mid + 1, high, target);
            }
        }
        return -1;
    }
}
