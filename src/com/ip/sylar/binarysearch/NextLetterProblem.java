package com.ip.sylar.binarysearch;

public class NextLetterProblem {
    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'd', 'f', 'h', 'k'};
        int n = arr.length;
        char target = 'k';

        System.out.println(findNextElement(arr, n, target));
    }

    private static char findNextElement(char[] arr, int n, char target) {
        int low = 0;
        int high = n - 1;
        char res = '\040';
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                low = mid + 1;
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
