package com.ip.sylar.searching;

public class SearchingAlgorithms {
    public static void main(String[] args) {
        int arr[] = {12, 13, 14, 37, 45, 67};
        //int ret = linearSearch(arr, arr.length, 13);
        int ret = binarySearch(arr, 0, arr.length - 1, 13);
        if (ret == -1) {
            System.out.println("element not found");
        } else {
            System.out.println("element found at index " + ret);
        }
    }

    private static int linearSearch(int[] arr, int length, int element) {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int start, int end, int element) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            if (arr[mid] > element)
                return binarySearch(arr, start, mid - 1, element);
            else
                return binarySearch(arr, mid + 1, end, element);
        }
        return -1;
    }
}
