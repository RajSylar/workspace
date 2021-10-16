package com.ip.sylar.binarysearch;

public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 12, 15, 32, 2, 5, 7};
        int n = arr.length;
        int target = 5;
        System.out.println(findElementInRotatedSortedArray(arr, n, target));
    }

    private static int findElementInRotatedSortedArray(int[] arr, int n, int target) {

        int index = findIndexOfMinimumElement(arr, n);
        if(index==-1)
            return -1;
        int low = 0;
        int high = n-1;
        while(low<= high)
        {
            if(target>=arr[0])
            {
                return binarySearch(arr, 0, index-1, target);
            }
            else if(target <=arr[high])
            {
                return binarySearch(arr, index, high, target);
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if(low<=high)
        {
            int mid = low +(high-low)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]<target)
            {
                return binarySearch(arr, mid+1, high, target);
            }
            else
            {
                return binarySearch(arr, low, mid-1, target);
            }
        }
        return -1;
    }

    private static int findIndexOfMinimumElement(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        if(n==0)
            return -1;
        if(n<2)
        {
            return 0;
        }
        if(arr[0] <= arr[n-1])
            return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[prev]>= arr[mid] && arr[next]>= arr[mid])
            {
                return mid;
            }
            else if(arr[0]<=arr[mid])
            {
                low = mid +1;
            }
            else if(arr[n-1]>=arr[mid])
            {
                high = mid-1;
            }
        }
        return -1;
    }
}
