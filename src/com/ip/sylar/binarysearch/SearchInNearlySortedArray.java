package com.ip.sylar.binarysearch;

public class SearchInNearlySortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 30, 20, 40};
        int target = 410;
        int n = arr.length;

        System.out.println(searchNearlySorted(arr, n, target));
    }

    private static int searchNearlySorted(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if ((mid-1)>= low && arr[mid - 1] == target)
                return mid - 1;
            else if ((mid+1) <= high && arr[mid + 1] == target)
                return mid + 1;
            else if (arr[mid] < target) {
                low = mid + 2;
            } else {
                high = mid - 2;
            }
        }
        return -1;
    }
}
