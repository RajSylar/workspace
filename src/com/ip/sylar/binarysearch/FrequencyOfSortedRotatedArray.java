package com.ip.sylar.binarysearch;

public class FrequencyOfSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 12, 15, 32, 2, 5, 7};
        int n = arr.length;

        System.out.println(frequencyOfRotation(arr, n));
    }

    private static int frequencyOfRotation(int[] nums, int n) {
        int low = 0;
        int high = n - 1;

        // if there is only one element
        if (low == high) {
            return nums[0];
        }
        // if array is not rotated at all
        if (nums[0] < nums[n - 1])
            return nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                low = mid + 1;
            } else if (nums[n - 1] >= nums[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];

            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
