package com.ip.sylar.heap;

import java.util.*;

public class TopKFrequentNumbers {

    static class Pair {
        private Integer freq;
        private Integer val;

        public Pair(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }

        public Integer getFreq() {
            return freq;
        }

        public void setFreq(Integer freq) {
            this.freq = freq;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 2, 2, 4};
        int k = 2;
        int n = arr.length;

        findTopFrequentNumbers(arr, k, n);
    }

    private static void findTopFrequentNumbers(int[] arr, int k, int n) {
        Comparator<Pair> freqComparator = Comparator.comparing(Pair::getFreq);
        PriorityQueue<Pair> pq = new PriorityQueue<>(freqComparator);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        Iterator<Pair> itr = pq.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next().val);
        }
    }
}
