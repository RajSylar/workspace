package com.ip.sylar.binarysearch;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 9, 12, 12, 12, 15, 32, 32};
        int target = 32;
        int n = arr.length;
        System.out.println(firstOccurIterative(arr, n, target));

        int low = 0;
        int high = n - 1;
        int res = -1;
        System.out.println(firstOccurRecursive(arr, low, high, target, res));

        System.out.println(lastOccurIterative(arr, n, target));

        System.out.println(lastOccurRecursive(arr, low, high, target, res));
    }

    private static int lastOccurRecursive(int[] arr, int low, int high, int target, int res) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                return lastOccurRecursive(arr, mid + 1, high, target, res);
            } else if (arr[mid] > target) {
                return lastOccurRecursive(arr, low, mid - 1, target, res);
            } else {
                return lastOccurRecursive(arr, mid + 1, high, target, res);
            }
        }
        return res;
    }

    private static int firstOccurRecursive(int[] arr, int low, int high, int target, int res) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                return firstOccurRecursive(arr, low, mid - 1, target, res);
            } else if (arr[mid] > target) {
                return firstOccurRecursive(arr, low, mid - 1, target, res);
            } else {
                return firstOccurRecursive(arr, mid + 1, high, target, res);
            }
        }
        return res;
    }

    private static int firstOccurIterative(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static int lastOccurIterative(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
