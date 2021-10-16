package com.ip.sylar.leetcode;

public class MountainArray {
    public static int longestMountain(int[] arr) {
        int maxLength = 0;
        int i = 1;

        while (i < arr.length) {
            int increasing = 0, decreasing = 0;

            while (i < arr.length && arr[i - 1] < arr[i]) {
                i++;
                increasing++;
            }
            while (i < arr.length && arr[i - 1] > arr[i]) {
                i++;
                decreasing++;
            }

            if (increasing > 0 && decreasing > 0) {
                maxLength = Math.max(maxLength, increasing + decreasing + 1);
            }

            while (i < arr.length && arr[i - 1] == arr[i])
                i++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,2,2,4,4,2};
        //int arr[] = new int[]{0,2,0,2,1,2,3,4,4,1};
        //int arr[] = new int[]{0,1,2,3,4,5,4,3,2,1,0};
        // int arr[] = new int[]{0,2,0,2,1,2,3,4,4,1};
        System.out.println(longestMountain(arr));
    }
}
