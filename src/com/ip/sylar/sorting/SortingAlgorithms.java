package com.ip.sylar.sorting;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        //bubbleSort(arr, arr.length);
        //selectionSort(arr, arr.length);
        //stableSelectionSort(arr, arr.length);
        //insertionSort(arr, arr.length);
        //binaryInsertionSort(arr, arr.length);
        quickSort(arr, 0, arr.length - 1);
        print(arr, arr.length);
    }

    private static void print(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    private static void selectionSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    private static void stableSelectionSort(int arr[], int len) {
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[i] = temp;
        }
    }

    private static void insertionSort(int arr[], int len) {
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void binaryInsertionSort(int arr[], int len) {
        int i, loc, j, k, key;

        for (i = 1; i < len; ++i) {
            j = i - 1;
            key = arr[i];

            loc = binarySearch(arr, key, 0, j);

            while (j >= loc) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int binarySearch(int a[], int item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    // merge, quick, heap, radix sort pending
    private static void mergeSort(int arr[], int len) {

    }

    private static void quickSort(int a[], int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        a[end] = a[i];
        a[i] = pivot;
        return i;
    }
}
