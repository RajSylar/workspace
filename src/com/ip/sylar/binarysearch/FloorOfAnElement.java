package com.ip.sylar.binarysearch;

public class FloorOfAnElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 8, 9, 11, 13, 15};
        int n = arr.length;
        int target = 7;
        System.out.println(findFloorOfElement(arr, n, target));
    }

    private static int findFloorOfElement(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                res = arr[mid];
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        return res;
    }
}
