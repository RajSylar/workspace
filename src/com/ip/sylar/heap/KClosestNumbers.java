package com.ip.sylar.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestNumbers {
    static class Pair {
        private Integer absIndexDiff;
        private Integer actualValue;

        public Pair(Integer idx, Integer val) {
            this.absIndexDiff = idx;
            this.actualValue = val;
        }

        public Integer getAbsIndexDiff() {
            return absIndexDiff;
        }

        public void setAbsIndexDiff(Integer absIndexDiff) {
            this.absIndexDiff = absIndexDiff;
        }

        public Integer getActualValue() {
            return actualValue;
        }

        public void setActualValue(Integer actualValue) {
            this.actualValue = actualValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,10,10,10};
        int k = 1;
        int n = arr.length;
        int target = 9;
        findKClosestNumber(arr, k, n, target);
    }

    private static void findKClosestNumber(int[] arr, int k, int n, int target) {
        Comparator<Pair> idxSorter = Comparator.comparing(Pair::getAbsIndexDiff).reversed();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(idxSorter);
//        for (int i = 0; i < n; i++) {
//            pq.add(new Pair(Math.abs(arr[i] - target), arr[i]));
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }

        for(int i=0; i<k; i++)
        {
            pq.add(new Pair(Math.abs(arr[i] - target), arr[i]));
        }

        for (int i=k; i<n; i++)
        {
            if(pq.peek().getAbsIndexDiff() > (arr[i] - target))
            {
                pq.poll();
                pq.add(new Pair(Math.abs(arr[i] - target), arr[i]));
            }
        }


        List<Pair> list = pq.stream().collect(Collectors.toList());
        Collections.sort(list, Comparator.comparing(Pair::getActualValue));
        list.forEach(l->
                System.out.println(l.getActualValue()));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        Comparator<Pair> idxSorter = Comparator.comparing(Pair::getAbsIndexDiff).reversed();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(idxSorter);
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Pair> list = pq.stream().collect(Collectors.toList());
        Collections.sort(list, Comparator.comparing(Pair::getActualValue));
        return list.stream().map(Pair::getActualValue).collect(Collectors.toList());

    }
}
