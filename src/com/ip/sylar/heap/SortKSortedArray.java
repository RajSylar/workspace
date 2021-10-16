package com.ip.sylar.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,3,2,8,10,9};
        int k =3;
        int n = arr.length;
        sortKSorted(arr, n, k);
    }

    private static void sortKSorted(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i=0; i<n; i++)
        {
            pq.add(arr[i]);

            if(pq.size() > k)
            {
                System.out.println(pq.poll());
            }
        }
        while(pq.size()>0) {
            System.out.println(pq.poll());
        }
    }
}
