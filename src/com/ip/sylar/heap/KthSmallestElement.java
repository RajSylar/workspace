package com.ip.sylar.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{7,10,4,3,20,15};
        int k =4;
        int n = arr.length;
        System.out.println(findKthSmallestElement(arr, n, k));
    }

    private static int findKthSmallestElement(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq
                = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<k; i++)
        {
            pq.add(arr[i]);
        }

        for (int i=k; i<n; i++)
        {
            if(pq.peek() > arr[i])
            {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }
}
