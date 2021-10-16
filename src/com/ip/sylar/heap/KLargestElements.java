package com.ip.sylar.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = new int[]{7,10,4,3,20,15};
        int k =1;
        int n = arr.length;
        findKLargestElements(arr, n, k);
    }

    private static void findKLargestElements(int[] arr, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i=0; i<n; i++)
        {
            pq.add(arr[i]);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        System.out.println(pq);
    }
}
